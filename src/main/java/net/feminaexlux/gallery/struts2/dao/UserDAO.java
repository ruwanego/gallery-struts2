package net.feminaexlux.gallery.struts2.dao;

import net.feminaexlux.gallery.struts2.model.Resource;
import net.feminaexlux.gallery.struts2.model.ResourceKey;
import net.feminaexlux.gallery.struts2.model.User;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

public class UserDAO extends ResourceDAO {
	public User findByUsername(String username) {
		TypedQuery<User> query = entityManager.createQuery("FROM User u WHERE u.username = :username", User.class);
		return query.getSingleResult();
	}

	public User save(User user) {
		return super.save(user);
	}
}
