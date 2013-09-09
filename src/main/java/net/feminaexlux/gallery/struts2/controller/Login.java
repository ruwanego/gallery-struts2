package net.feminaexlux.gallery.struts2.controller;

import com.opensymphony.xwork2.ActionContext;
import net.feminaexlux.gallery.struts2.model.Session;
import net.feminaexlux.gallery.struts2.model.User;
import net.feminaexlux.gallery.struts2.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Map;

public class Login extends Controller {
	private static final Logger LOG = LogManager.getLogger(Login.class);
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";

	@Autowired
	private UserService userService;

	private Map<String, String> form;

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	public String login() {
		try {
			User loggedInUser = userService.loginUser(form.get(LOGIN), form.get(PASSWORD));
			Session session = new Session(loggedInUser.getId(), new Date());
			ActionContext.getContext().getSession().put("session", session);

			return redirectToAction("Administration");
		} catch (SecurityException securityException) {
			LOG.error("{}\n{}", securityException.getMessage(), securityException);
			addActionMessage("Incorrect login or password");
		}

		return SUCCESS;
	}

	public Map<String, String> getForm() {
		return form;
	}

	public void setForm(Map<String, String> form) {
		this.form = form;
	}
}
