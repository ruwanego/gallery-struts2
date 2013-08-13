package net.feminaexlux.gallery.struts2.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
@PrimaryKeyJoinColumns({
		@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id"),
		@PrimaryKeyJoinColumn(name = "type", referencedColumnName = "type")
})
public class User extends Resource {
	private String login;
	private String password;

	@Column(nullable = false, length = 50)
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(nullable = false, length = 50)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
