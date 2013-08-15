package net.feminaexlux.gallery.struts2.controller;

import net.feminaexlux.gallery.struts2.model.Album;
import net.feminaexlux.gallery.struts2.model.Image;
import net.feminaexlux.gallery.struts2.service.AlbumService;
import net.feminaexlux.gallery.struts2.service.ImageService;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Administration extends Controller {
	private static final Logger LOG = LogManager.getLogger(Administration.class);

	@Autowired
	private AlbumService albumService;
	@Autowired
	private ImageService imageService;

	private int albumId;
	private File upload;
	private String uploadFileName;
	private String uploadContentType;

	public String upload() {
		if (upload != null && albumId > 0) {
			try {
				byte[] byteArray = FileUtils.readFileToByteArray(upload);

				Album album = albumService.getAlbum(albumId);
				Image image = new Image();
				image.setAlbum(album);
				image.setImage(byteArray);
				image.setThumbnail(byteArray);
				image.setName(uploadFileName);
				image.setContentType(uploadContentType);

				imageService.save(image);
			} catch (IOException ioException) {
				LOG.error("Error with upload {}\n{}", uploadFileName, ioException);
			}
		}

		return redirectToAction("Administration");
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public List<Album> getAlbums() {
		return albumService.getAll();
	}

	public List<Image> getImages() {
		return imageService.getAll();
	}
}
