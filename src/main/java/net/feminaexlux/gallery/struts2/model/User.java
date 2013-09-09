package net.feminaexlux.gallery.struts2.model;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@DiscriminatorValue(ResourceType.USER)
@SecondaryTable(name = "user", pkJoinColumns = {
		@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "resource_id")
})
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class User extends Resource {
	@Column(table = "user", name = "user_login", nullable = false, length = 50)
	private String login;

	@Column(table = "user", name = "user_password", nullable = false, length = 50)
	private String password;

	public User() {
		this.type = ResourceType.USER;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
