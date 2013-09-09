package net.feminaexlux.gallery.struts2.dao;

import net.feminaexlux.gallery.struts2.model.Album;

import javax.persistence.TypedQuery;
import java.util.List;

public class AlbumDAO extends ResourceDAO<Album> {
	public List<Album> getTopLevelAlbums() {
		TypedQuery<Album> query = entityManager.createQuery("FROM Album a WHERE a.parent IS NULL", Album.class);
		return query.getResultList();
	}
}
