package net.feminaexlux.gallery.struts2.model;

import javax.persistence.*;

@Entity
@Table(name = "image")
@PrimaryKeyJoinColumns({
		@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id"),
		@PrimaryKeyJoinColumn(name = "type", referencedColumnName = "type")
})
public class Image extends Resource implements Linkable {
	private Album album;
	private byte[] image;
	private byte[] thumbnail;
	private String contentType;
	private String description;
	private String slug;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "album_id", referencedColumnName = "id"),
			@JoinColumn(name = "album_type", referencedColumnName = "type")
	})
	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album parent) {
		this.album = parent;
	}

	@Column(nullable = false)
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Column(nullable = false)
	public byte[] getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(byte[] thumbnail) {
		this.thumbnail = thumbnail;
	}

	@Column(name = "content_type", nullable = false, length = 50)
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Column(nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(nullable = false, length = 100)
	@Override
	public String getSlug() {
		return slug;
	}

	@Override
	public void setSlug(String slug) {
		this.slug = slug;
	}
}
