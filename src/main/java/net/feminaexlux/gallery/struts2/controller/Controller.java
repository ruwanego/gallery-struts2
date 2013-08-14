package net.feminaexlux.gallery.struts2.controller;

import com.opensymphony.xwork2.ActionSupport;

public class Controller extends ActionSupport {
	public static final String REDIRECT = "redirect";

	private String action;

	public String redirectToAction(String action) {
		this.action = action;

		return REDIRECT;
	}

	public String getAction() {
		return action;
	}
}
