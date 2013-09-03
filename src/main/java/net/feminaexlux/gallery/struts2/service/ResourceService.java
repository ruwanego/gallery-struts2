package net.feminaexlux.gallery.struts2.service;

import net.feminaexlux.gallery.struts2.dao.ResourceDAO;
import net.feminaexlux.gallery.struts2.model.Linkable;
import net.feminaexlux.gallery.struts2.model.Resource;
import net.feminaexlux.gallery.struts2.utility.StringUtility;

import java.util.Date;

public abstract class ResourceService<T extends Resource> {
	public T get(int id, String type, Class<T> resourceClass) {
		return dao().find(resourceClass, id, type);
	}

	public T save(T resource) {
		if (resource.getId() > 0) {
			resource.setUpdated(new Date());
		}

		if (resource instanceof Linkable) {
			((Linkable) resource).setSlug(StringUtility.createSlug(resource.getName()));
		}

		return dao().save(resource);
	}

	protected abstract <D extends ResourceDAO<T>> D dao();
}
