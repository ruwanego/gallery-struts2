package net.feminaexlux.gallery.struts2.dao;

import net.feminaexlux.gallery.struts2.model.Resource;
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

	public T find(Class<T> clazz, int id, String type) {
		TypedQuery<T> query = entityManager.createQuery("FROM " + clazz.getSimpleName() + " t " +
				"WHERE t.id = :id AND t.type = :type", clazz);

		query.setParameter("id", id);
		query.setParameter("type", type);

		return query.getSingleResult();
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
				// FIXME: hacky way of doing things
				Query query = entityManager.createNativeQuery("SELECT MAX(resource_id) FROM resource");
				int id = (Integer) query.getSingleResult();
				resource.setId(id + 1);

				entityManager.persist(resource);
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
}
