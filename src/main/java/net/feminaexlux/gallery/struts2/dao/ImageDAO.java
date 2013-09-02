package net.feminaexlux.gallery.struts2.dao;

import net.feminaexlux.gallery.struts2.model.Image;

import javax.persistence.EntityManager;

public class ImageDAO extends ResourceDAO<Image> {
	@Override
	protected void saveNew(Image resource, EntityManager entityManager) {
	}
}
