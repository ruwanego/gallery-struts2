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

	public void loginUser(String login, String password) throws SecurityException {
		User potentialUser = findByUsername(login);
		String encryptedPassword = encrypt(password, potentialUser);

		if (!potentialUser.getPassword().equals(encryptedPassword)) {
			throw new SecurityException("Wrong login credentials for user " + login);
		}
	}

	private String encrypt(String password, User potentialUser) {
		return null;
	}
}
