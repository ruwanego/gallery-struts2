package net.feminaexlux.gallery.struts2.service;

import net.feminaexlux.gallery.struts2.dao.ResourceDAO;
import net.feminaexlux.gallery.struts2.model.Linkable;
import net.feminaexlux.gallery.struts2.model.Resource;
import net.feminaexlux.gallery.struts2.model.ResourceKey;
import net.feminaexlux.gallery.struts2.utility.StringUtility;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ResourceService {
	@Autowired
	protected ResourceDAO resourceDAO;

	public <T extends Resource> T get(int id, String type, Class<T> resourceClass) {
		return resourceDAO.find(resourceClass, new ResourceKey(id, type));
	}

	public <T extends Resource> T save(T resource) {
		if (resource.getId() > 0) {
			resource.setUpdated(new Date());
		}

		if (resource instanceof Linkable) {
			((Linkable) resource).setSlug(StringUtility.createSlug(resource.getName()));
		}

		return resourceDAO.save(resource);
	}
}
