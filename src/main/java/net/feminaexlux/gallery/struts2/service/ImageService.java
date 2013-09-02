package net.feminaexlux.gallery.struts2.service;

import net.feminaexlux.gallery.struts2.dao.ImageDAO;
import net.feminaexlux.gallery.struts2.model.Image;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ImageService extends ResourceService<Image> {
	@Autowired
	private ImageDAO imageDAO;

	public Image getImage(final int id, final String type) {
		return super.get(id, type, Image.class);
	}

	public List<Image> getAll() {
		return dao().findAll(Image.class);
	}

	@Override
	protected ImageDAO dao() {
		return imageDAO;
	}
}
