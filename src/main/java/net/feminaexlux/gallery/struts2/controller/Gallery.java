package net.feminaexlux.gallery.struts2.controller;

import com.opensymphony.xwork2.ActionSupport;
import net.feminaexlux.gallery.struts2.model.Resource;

import java.util.List;

public class Gallery extends ActionSupport {
	private List<Resource> resources;

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
}
