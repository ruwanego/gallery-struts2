package net.feminaexlux.gallery.struts2.controller;

import com.opensymphony.xwork2.ActionSupport;
import net.feminaexlux.gallery.struts2.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class Login extends ActionSupport {
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
		if (formIsMissingFields()) {
			addActionMessage("Missing information");
		} else {
			try {
				userService.loginUser(form.get(LOGIN), form.get(PASSWORD));
				addActionMessage("Successfully logged in");
			} catch (SecurityException securityException) {
				LOG.error("{} tried to log in with incorrect credentials\n{}", form.get(LOGIN), securityException);
				addActionMessage("Incorrect login or password");
			}
		}

		return SUCCESS;
	}

	private boolean formIsMissingFields() {
		return form == null || form.isEmpty()
				|| StringUtils.isEmpty(form.get(LOGIN))
				|| StringUtils.isEmpty(form.get(PASSWORD));
	}

	public Map<String, String> getForm() {
		return form;
	}

	public void setForm(Map<String, String> form) {
		this.form = form;
	}
}
