package net.feminaexlux.gallery.struts2.service;

import net.feminaexlux.gallery.struts2.dao.ResourceDAO;
import net.feminaexlux.gallery.struts2.model.Resource;
import net.feminaexlux.gallery.struts2.model.ResourceKey;
import net.feminaexlux.gallery.struts2.model.ResourceType;
import org.springframework.beans.factory.annotation.Autowired;

public class ResourceService {
	@Autowired
	private ResourceDAO resourceDAO;

	public Resource getAlbum(int id) {
		return resourceDAO.find(Resource.class, new ResourceKey(id, ResourceType.ALBUM));
	}
}
