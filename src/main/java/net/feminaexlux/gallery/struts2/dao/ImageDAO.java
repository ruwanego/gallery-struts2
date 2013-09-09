package net.feminaexlux.gallery.struts2.dao;

import net.feminaexlux.gallery.struts2.model.Image;

import javax.persistence.TypedQuery;

public class ImageDAO extends ResourceDAO<Image> {
	public Image findBySlug(final String slug) {
		TypedQuery<Image> query = entityManager.createQuery("FROM Image i WHERE i.slug = :slug", Image.class);
		query.setParameter("slug", slug);
		return query.getSingleResult();
	}
}
