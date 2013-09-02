package net.feminaexlux.gallery.struts2.controller;

import net.feminaexlux.gallery.struts2.model.Album;
import net.feminaexlux.gallery.struts2.model.Resource;
import net.feminaexlux.gallery.struts2.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;

public class Gallery extends Controller {
	public static final int ALBUM_ID = 2;

	@Autowired
	private AlbumService albumService;

	private Album album;

	@Override
	public String execute() throws Exception {
		album = albumService.getAlbum(ALBUM_ID);

		return SUCCESS;
	}

	public String save() {
		album = albumService.getAlbum(ALBUM_ID);
		album.setDescription("Test");
		album.setName("Test");

		albumService.save(album);

		return SUCCESS;
	}

	public String revert() {
		album = albumService.getAlbum(ALBUM_ID);
		album.setDescription("Original Art");
		album.setName("Originals");

		albumService.save(album);

		return SUCCESS;
	}

	public Resource getAlbum() {
		return album;
	}
}
