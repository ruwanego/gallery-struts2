package net.feminaexlux.gallery.struts2.controller;

import net.feminaexlux.gallery.struts2.model.Image;
import net.feminaexlux.gallery.struts2.service.ImageService;
import net.feminaexlux.gallery.struts2.utility.StringUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class ImageLoader extends Controller {
	private static final Logger LOG = LogManager.getLogger(ImageLoader.class);

	@Autowired
	private ImageService imageService;

	private String slug;

	public String image() {
		if (StringUtility.isNotEmpty(slug)) {
			try {
				Image image = imageService.getImageBySlug(slug);
				prepareResponse(image.getName(), image.getContentType(), image.getImage());
			} catch (IOException ioException) {
				LOG.error("Error uploading file {}\n{}", slug, ioException);
			}
		}

		return SUCCESS;
	}

	public String thumbnail() {
		if (StringUtility.isNotEmpty(slug)) {
			try {
				Image image = imageService.getImageBySlug(slug);
				prepareResponse(image.getName(), image.getContentType(), image.getThumbnail());
			} catch (IOException ioException) {
				LOG.error("Error uploading file {}\n{}", slug, ioException);
			}
		}

		return SUCCESS;
	}

	private void prepareResponse(final String name, final String contentType, final byte[] data) throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Content-Disposition", "attachment;filename=" + name);
		response.setContentType(contentType);
		response.setContentLength(data.length);

		OutputStream outputStream = response.getOutputStream();
		outputStream.write(data);
		outputStream.flush();
		outputStream.close();
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}
}
