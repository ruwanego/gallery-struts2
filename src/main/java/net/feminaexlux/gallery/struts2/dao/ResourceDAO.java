package net.feminaexlux.gallery.struts2.dao;

import net.feminaexlux.gallery.struts2.model.Resource;
import net.feminaexlux.gallery.struts2.model.ResourceKey;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

public abstract class ResourceDAO<T extends Resource> {
	protected EntityManagerFactory entityManagerFactory;
	protected EntityManager entityManager;

	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public T find(Class<T> clazz, ResourceKey key) {
		return entityManager.find(clazz, key);
	}

	public List<T> findAll(Class<T> clazz) {
		TypedQuery<T> query = entityManager.createQuery("FROM " + clazz.getSimpleName(), clazz);
		return query.getResultList();
	}

	@Transactional
	public T save(T resource) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		try {
			if (resource.getId() == 0) {
				saveNew(resource, entityManager);
			} else {
				entityManager.merge(resource);
			}

			entityManager.flush();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}

		return resource;
	}

	protected abstract void saveNew(T resource, EntityManager entityManager);
}
