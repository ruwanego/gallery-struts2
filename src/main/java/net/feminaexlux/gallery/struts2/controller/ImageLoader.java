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

	private int imageId;
	private String imageType;

	public String image() {
		if (imageId > 0 && StringUtility.isNotEmpty(imageType)) {
			try {
				Image image = imageService.getImage(imageId, imageType);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setHeader("Content-Disposition", "attachment;filename=" + image.getName());
				response.setContentType(image.getContentType());
				response.setContentLength(image.getImage().length);

				OutputStream outputStream = response.getOutputStream();
				outputStream.write(image.getImage());
				outputStream.flush();
				outputStream.close();
			} catch (IOException ioException) {
				LOG.error("Error uploading file {}\n{}", imageId, ioException);
			}
		}

		return SUCCESS;
	}

	public String thumbnail() {
		return SUCCESS;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
}
