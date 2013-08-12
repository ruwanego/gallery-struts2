package net.feminaexlux.gallery.struts2.dao;

import net.feminaexlux.gallery.struts2.model.Resource;
import net.feminaexlux.gallery.struts2.model.ResourceKey;

public class ResourceDAO extends DAO {
	public <T extends Resource> T find(Class<T> clazz, ResourceKey key) {
		return entityManager.find(clazz, key);
	}
}
