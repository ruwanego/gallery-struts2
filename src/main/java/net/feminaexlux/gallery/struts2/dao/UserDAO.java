package net.feminaexlux.gallery.struts2.dao;

import net.feminaexlux.gallery.struts2.model.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UserDAO extends ResourceDAO<User> {
	public User findByUsername(String login) {
		TypedQuery<User> query = entityManager.createQuery("FROM User u WHERE u.login = :login", User.class);

		query.setParameter("login", login);

		return query.getSingleResult();
	}

	public User save(User user) {
		return super.save(user);
	}

	@Override
	protected void saveNew(User resource, EntityManager entityManager) {
	}
}
