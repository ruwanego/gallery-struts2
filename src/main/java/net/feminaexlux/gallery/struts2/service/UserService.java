package net.feminaexlux.gallery.struts2.service;

import net.feminaexlux.gallery.struts2.dao.UserDAO;
import net.feminaexlux.gallery.struts2.model.User;
import net.feminaexlux.gallery.struts2.utility.StringUtility;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService extends ResourceService<User> {
	@Autowired
	private UserDAO userDAO;

	public User findByUsername(String username) {
		return userDAO.findByUsername(username);
	}

	public User loginUser(String login, String password) throws SecurityException {
		if (StringUtility.isEmpty(login) || StringUtility.isEmpty(password)) {
			throw new SecurityException("Missing login information for " + login);
		}

		User potentialUser = findByUsername(login);
		String encryptedPassword = StringUtility.encrypt(password, potentialUser);

		if (!potentialUser.getPassword().equals(encryptedPassword)) {
			throw new SecurityException("Wrong login credentials for user " + login);
		}

		return potentialUser;
	}

	@Override
	protected UserDAO dao() {
		return userDAO;
	}
}
