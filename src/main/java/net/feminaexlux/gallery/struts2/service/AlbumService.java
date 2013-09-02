package net.feminaexlux.gallery.struts2.service;

import net.feminaexlux.gallery.struts2.dao.AlbumDAO;
import net.feminaexlux.gallery.struts2.dao.ResourceDAO;
import net.feminaexlux.gallery.struts2.model.Album;
import net.feminaexlux.gallery.struts2.model.ResourceType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AlbumService extends ResourceService<Album> {
	@Autowired
	private AlbumDAO albumDAO;

	public Album getAlbum(int id) {
		return super.get(id, ResourceType.ALBUM, Album.class);
	}

	public List<Album> getAll() {
		return albumDAO.findAll(Album.class);
	}

	@Override
	protected ResourceDAO dao() {
		return albumDAO;
	}
}
