package net.feminaexlux.gallery.struts2.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "resource")
@Inheritance(strategy = InheritanceType.JOINED)
public class Resource {
	protected ResourceKey key;
	protected String name;
	protected Date created;
	protected Date updated;
	protected Date deleted;

	@EmbeddedId
	public ResourceKey getKey() {
		return key;
	}

	public void setKey(ResourceKey key) {
		this.key = key;
	}

	@Transient
	public int getId() {
		if (key == null) {
			return 0;
		}

		return key.getId();
	}

	@Transient
	public ResourceType getType() {
		if (key == null) {
			return null;
		}

		return key.getType();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Date getDeleted() {
		return deleted;
	}

	public void setDeleted(Date deleted) {
		this.deleted = deleted;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Resource resource = (Resource) o;

		if (created != null ? !created.equals(resource.created) : resource.created != null) return false;
		if (deleted != null ? !deleted.equals(resource.deleted) : resource.deleted != null) return false;
		if (key != null ? !key.equals(resource.key) : resource.key != null) return false;
		if (name != null ? !name.equals(resource.name) : resource.name != null) return false;
		if (updated != null ? !updated.equals(resource.updated) : resource.updated != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = key != null ? key.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (created != null ? created.hashCode() : 0);
		result = 31 * result + (updated != null ? updated.hashCode() : 0);
		result = 31 * result + (deleted != null ? deleted.hashCode() : 0);
		return result;
	}
}
