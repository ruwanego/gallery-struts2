package net.feminaexlux.gallery.struts2.configuration;

import net.feminaexlux.gallery.struts2.dao.ResourceDAO;
import net.feminaexlux.gallery.struts2.dao.UserDAO;
import net.feminaexlux.gallery.struts2.service.AlbumService;
import net.feminaexlux.gallery.struts2.service.ResourceService;
import net.feminaexlux.gallery.struts2.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Configuration
@Import({ORM.class})
public class Beans {
	// DAOs
	@Bean
	public ResourceDAO resourceDAO() {
		return new ResourceDAO();
	}

	@Bean
	public UserDAO userDAO() {
		return new UserDAO();
	}

	// Services
	@Bean
	@Scope("prototype")
	public ResourceService resourceService() {
		return new ResourceService();
	}

	@Bean
	@Scope("prototype")
	public AlbumService albumService() {
		return new AlbumService();
	}

	@Bean
	@Scope("prototype")
	public UserService userService() {
		return new UserService();
	}
}
