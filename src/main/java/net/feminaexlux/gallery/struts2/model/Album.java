package net.feminaexlux.gallery.struts2.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue(ResourceType.ALBUM)
@SecondaryTable(name = "album", pkJoinColumns = {
		@PrimaryKeyJoinColumn(name = "album_id", referencedColumnName = "resource_id"),
		@PrimaryKeyJoinColumn(name = "album_type", referencedColumnName = "resource_type")
})
public class Album extends Resource implements Linkable {
	private Album parent;
	private String description;
	private String slug;

	public Album() {
		this.key = new ResourceKey(0, ResourceType.ALBUM);
	}

	@ManyToOne
	@JoinColumns({
			@JoinColumn(table = "album", name = "album_parent_id", referencedColumnName = "resource_id"),
			@JoinColumn(table = "album", name = "album_parent_type", referencedColumnName = "resource_type")
	})
	public Album getParent() {
		return parent;
	}

	public void setParent(Album parent) {
		this.parent = parent;
	}

	@Column(table = "album", name = "album_description", nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(table = "album", name = "album_slug", nullable = false, length = 100)
	@Override
	public String getSlug() {
		return slug;
	}

	@Override
	public void setSlug(String slug) {
		this.slug = slug;
	}
}
