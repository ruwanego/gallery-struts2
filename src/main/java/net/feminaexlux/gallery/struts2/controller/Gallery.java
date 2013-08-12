package net.feminaexlux.gallery.struts2.controller;

import com.opensymphony.xwork2.ActionSupport;
import net.feminaexlux.gallery.struts2.model.Resource;
import net.feminaexlux.gallery.struts2.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;

public class Gallery extends ActionSupport {
	@Autowired
	private ResourceService resourceService;

	private Resource album;

	@Override
	public String execute() throws Exception {
		album = resourceService.getAlbum(1);

		return SUCCESS;
	}

	public Resource getAlbum() {
		return album;
	}
}
