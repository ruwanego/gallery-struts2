package net.feminaexlux.gallery.struts2.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ResourceKey implements Serializable {
	private int id;
	private ResourceType type;

	public ResourceKey() {
	}

	public ResourceKey(int id, String type) {
		this.id = id;
		this.type = new ResourceType(type);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "type", referencedColumnName = "type")
	public ResourceType getType() {
		return type;
	}

	public void setType(ResourceType type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ResourceKey that = (ResourceKey) o;

		if (id != that.id) return false;
		if (type != null ? !type.equals(that.type) : that.type != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (type != null ? type.hashCode() : 0);
		return result;
	}
}
