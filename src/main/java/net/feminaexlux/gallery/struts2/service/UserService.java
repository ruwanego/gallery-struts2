package net.feminaexlux.gallery.struts2.service;

import net.feminaexlux.gallery.struts2.dao.UserDAO;
import net.feminaexlux.gallery.struts2.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService extends ResourceService {
	@Autowired
	private UserDAO userDAO;

	public User findByUsername(String username) {
		return userDAO.findByUsername(username);
	}
}
