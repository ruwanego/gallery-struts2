package net.feminaexlux.gallery.struts2.dao;

import net.feminaexlux.gallery.struts2.model.Album;

import javax.persistence.EntityManager;

public class AlbumDAO extends ResourceDAO<Album> {
	@Override
	protected void saveNew(Album album, EntityManager entityManager) {

	}
}
