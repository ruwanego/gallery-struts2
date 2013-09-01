package net.feminaexlux.gallery.struts2.service;

import net.feminaexlux.gallery.struts2.model.Image;

import java.util.List;

public class ImageService extends ResourceService {
	public Image getImage(final int id, final String type) {
		return super.get(id, type, Image.class);
	}

	public List<Image> getAll() {
		return resourceDAO.findAll(Image.class);
	}
}
