package net.feminaexlux.gallery.struts2.model;

import javax.persistence.*;

@Entity
@Table(name = "album")
@PrimaryKeyJoinColumns({
		@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id"),
		@PrimaryKeyJoinColumn(name = "type", referencedColumnName = "type")
})
public class Album extends Resource implements Linkable {
	private Album parent;
	private String description;
	private String slug;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "parent_id", referencedColumnName = "id"),
			@JoinColumn(name = "parent_type", referencedColumnName = "type")
	})
	public Album getParent() {
		return parent;
	}

	public void setParent(Album parent) {
		this.parent = parent;
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
