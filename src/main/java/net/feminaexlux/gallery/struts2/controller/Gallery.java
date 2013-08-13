package net.feminaexlux.gallery.struts2.controller;

import com.opensymphony.xwork2.ActionSupport;
import net.feminaexlux.gallery.struts2.model.Album;
import net.feminaexlux.gallery.struts2.model.Resource;
import net.feminaexlux.gallery.struts2.model.ResourceType;
import net.feminaexlux.gallery.struts2.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;

public class Gallery extends ActionSupport {
	@Autowired
	private AlbumService albumService;

	private Album album;

	@Override
	public String execute() throws Exception {
		album = albumService.getAlbum(1);

		return SUCCESS;
	}

	public String save() {
		album = albumService.getAlbum(1);
		album.setDescription("Test");
		album.setName("Test");

		albumService.save(album);

		return SUCCESS;
	}

	public String revert() {
		album = albumService.getAlbum(1);
		album.setDescription("Original Art");
		album.setName("Originals");

		albumService.save(album);

		return SUCCESS;
	}

	public Resource getAlbum() {
		return album;
	}
}
