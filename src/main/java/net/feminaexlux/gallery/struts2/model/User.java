package net.feminaexlux.gallery.struts2.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue(ResourceType.USER)
@SecondaryTable(name = "user", pkJoinColumns = {
		@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "resource_id"),
		@PrimaryKeyJoinColumn(name = "user_type", referencedColumnName = "resource_type")
})
public class User extends Resource {
	@Column(table = "user", name = "user_login", nullable = false, length = 50)
	private String login;

	@Column(table = "user", name = "user_password", nullable = false, length = 50)
	private String password;

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
