package net.feminaexlux.gallery.struts2.dao;

import net.feminaexlux.gallery.struts2.model.Resource;
import net.feminaexlux.gallery.struts2.model.ResourceKey;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

public class ResourceDAO {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public <T extends Resource> T find(Class<T> clazz, ResourceKey key) {
		return entityManager.find(clazz, key);
	}

	@Transactional
	public <T extends Resource> T save(T resource) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		entityManager.merge(resource);
		entityManager.flush();

		entityManager.getTransaction().commit();

		return resource;
	}
}
