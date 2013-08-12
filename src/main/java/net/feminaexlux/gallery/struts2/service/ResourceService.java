package net.feminaexlux.gallery.struts2.service;

import net.feminaexlux.gallery.struts2.dao.ResourceDAO;
import net.feminaexlux.gallery.struts2.model.Album;
import net.feminaexlux.gallery.struts2.model.ResourceKey;
import net.feminaexlux.gallery.struts2.model.ResourceType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ResourceService {
	@Autowired
	private ResourceDAO resourceDAO;

	public Album getAlbum(int id) {
		return resourceDAO.find(Album.class, new ResourceKey(id, ResourceType.ALBUM));
	}

	public Album save(Album album) {
		if (album.getId() > 0) {
			album.setUpdated(new Date());
		}

		return resourceDAO.save(album);
	}
}
