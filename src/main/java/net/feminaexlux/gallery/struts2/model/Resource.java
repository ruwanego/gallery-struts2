package net.feminaexlux.gallery.struts2.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "resource")
public class Resource {
	protected int id;
	protected ResourceType type;
	protected String name;
	protected Date created;
	protected Date updated;
	protected Date deleted;

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@PrimaryKeyJoinColumn(name = "type", referencedColumnName = "type")
	public ResourceType getType() {
		return type;
	}

	public void setType(ResourceType type) {
		this.type = type;
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
}
