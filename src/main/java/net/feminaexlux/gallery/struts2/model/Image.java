package net.feminaexlux.gallery.struts2.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue(ResourceType.IMAGE)
@SecondaryTable(name = "image", pkJoinColumns = {
		@PrimaryKeyJoinColumn(name = "image_id", referencedColumnName = "resource_id"),
		@PrimaryKeyJoinColumn(name = "image_type", referencedColumnName = "resource_type")
})
public class Image extends Resource implements Linkable {
	public Image() {
		this.key = new ResourceKey(0, ResourceType.IMAGE);
	}

	public Image(String type) {
		this.key = new ResourceKey(0, type);
	}

	private Album album;
	private byte[] image;
	private byte[] thumbnail;
	private String contentType;
	private String description;
	private String slug;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(table = "image", name = "image_album_id", referencedColumnName = "resource_id"),
			@JoinColumn(table = "image", name = "image_album_type", referencedColumnName = "resource_type")
	})
	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album parent) {
		this.album = parent;
	}

	@Column(table = "image", name = "image_content", nullable = false)
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Column(table = "image", name = "image_thumbnail", nullable = false)
	public byte[] getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(byte[] thumbnail) {
		this.thumbnail = thumbnail;
	}

	@Column(table = "image", name = "image_content_type", nullable = false, length = 50)
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Column(table = "image", name = "image_description", nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(table = "image", name = "image_slug", nullable = false, length = 50)
	@Override
	public String getSlug() {
		return slug;
	}

	@Override
	public void setSlug(String slug) {
		this.slug = slug;
	}
}
