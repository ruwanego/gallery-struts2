package net.feminaexlux.gallery.struts2.service;

import net.feminaexlux.gallery.struts2.model.Album;
import net.feminaexlux.gallery.struts2.model.ResourceType;

import java.util.List;

public class AlbumService extends ResourceService {
	public Album getAlbum(int id) {
		return super.get(id, ResourceType.ALBUM, Album.class);
	}

	public List<Album> getAll() {
		return resourceDAO.findAll(Album.class);
	}
}
