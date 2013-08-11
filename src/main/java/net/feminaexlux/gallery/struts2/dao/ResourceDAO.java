package net.feminaexlux.gallery.struts2.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class ResourceDAO {
	protected EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
