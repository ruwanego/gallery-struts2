package net.feminaexlux.gallery.struts2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "resource_type")
public class ResourceType {
	public static final String ALBUM = "Album";
	public static final String COMIC = "Comic";
	public static final String IMAGE = "Image";
	public static final String NSFW = "Nsfw";
	public static final String TAG = "Tag";
	public static final String ADMIN = "Admin";

	private String type;

	public ResourceType() {
	}

	public ResourceType(String type) {
		this.type = type;
	}

	@Id
	@Column(name = "type", nullable = false, length = 50)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ResourceType that = (ResourceType) o;

		if (type != null ? !type.equals(that.type) : that.type != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return type != null ? type.hashCode() : 0;
	}

	@Override
	public String toString() {
		return type;
	}
}
