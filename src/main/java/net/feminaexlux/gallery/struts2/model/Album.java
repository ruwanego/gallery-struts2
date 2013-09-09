package net.feminaexlux.gallery.struts2.model;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue(ResourceType.ALBUM)
@SecondaryTable(name = "album", pkJoinColumns = {
		@PrimaryKeyJoinColumn(name = "album_id", referencedColumnName = "resource_id")
})
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Album extends Resource implements Linkable {
	@ManyToOne
	@JoinColumn(table = "album", name = "album_parent_id", referencedColumnName = "resource_id")
	private Album parent;

	@Column(table = "album", name = "album_description", nullable = false)
	private String description;

	@Column(table = "album", name = "album_slug", nullable = false, length = 100)
	private String slug;

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private List<Album> children = new ArrayList<>();

	@OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
	private List<Image> images = new ArrayList<>();

	public Album() {
		this.type = ResourceType.ALBUM;
	}

	public Album getParent() {
		return parent;
	}

	public void setParent(Album parent) {
		this.parent = parent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getSlug() {
		return slug;
	}

	@Override
	public void setSlug(String slug) {
		this.slug = slug;
	}

	public List<Album> getChildren() {
		return children;
	}

	public void setChildren(List<Album> children) {
		this.children = children;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
}
