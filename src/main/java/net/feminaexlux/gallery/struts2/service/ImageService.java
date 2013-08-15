package net.feminaexlux.gallery.struts2.service;

import net.feminaexlux.gallery.struts2.model.Image;
import net.feminaexlux.gallery.struts2.model.ResourceType;

import java.util.List;

public class ImageService extends ResourceService {
	public Image getImage(int id) {
		return super.get(id, ResourceType.IMAGE, Image.class);
	}

	public Image getImage(int id, String type) {
		return super.get(id, type, Image.class);
	}

	public List<Image> getAll() {
		return resourceDAO.findAll(Image.class);
	}
}
