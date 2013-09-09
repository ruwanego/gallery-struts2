package net.feminaexlux.gallery.struts2.service;

import net.feminaexlux.gallery.struts2.dao.ImageDAO;
import net.feminaexlux.gallery.struts2.model.Image;
import net.feminaexlux.gallery.struts2.model.ResourceType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ImageService extends ResourceService<Image> {
	@Autowired
	private ImageDAO imageDAO;

	public Image getImage(final int id) {
		return super.get(id, ResourceType.IMAGE, Image.class);
	}

	public Image getImageBySlug(final String slug) {
		return dao().findBySlug(slug);
	}

	public List<Image> getAll() {
		return dao().findAll(Image.class);
	}

	@Override
	protected ImageDAO dao() {
		return imageDAO;
	}
}
