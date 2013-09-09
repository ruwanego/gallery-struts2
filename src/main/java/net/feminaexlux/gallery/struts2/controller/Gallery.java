package net.feminaexlux.gallery.struts2.controller;

import net.feminaexlux.gallery.struts2.model.Album;
import net.feminaexlux.gallery.struts2.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Gallery extends Controller {
	@Autowired
	private AlbumService albumService;

	private Album album;
	private List<Album> albums;

	@Override
	public String execute() throws Exception {
		albums = albumService.getTopLevelAlbums();

		return SUCCESS;
	}

	public String save() {
		return SUCCESS;
	}

	public Album getAlbum() {
		return album;
	}

	public List<Album> getAlbums() {
		return albums;
	}
}
