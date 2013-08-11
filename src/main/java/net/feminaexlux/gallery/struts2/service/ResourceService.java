package net.feminaexlux.gallery.struts2.service;

import com.opensymphony.xwork2.inject.Inject;
import net.feminaexlux.gallery.struts2.dao.ResourceDAO;

public abstract class ResourceService {
	@Inject
	private ResourceDAO resourceDAO;
}
