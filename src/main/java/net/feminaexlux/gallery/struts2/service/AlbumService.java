package net.feminaexlux.gallery.struts2.service;

import net.feminaexlux.gallery.struts2.model.Album;
import net.feminaexlux.gallery.struts2.model.ResourceType;

public class AlbumService extends ResourceService {
	public Album getAlbum(int id) {
		return super.get(id, ResourceType.ALBUM, Album.class);
	}
}
