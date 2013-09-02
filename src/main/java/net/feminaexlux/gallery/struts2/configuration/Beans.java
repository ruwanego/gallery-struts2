package net.feminaexlux.gallery.struts2.configuration;

import net.feminaexlux.gallery.struts2.dao.AlbumDAO;
import net.feminaexlux.gallery.struts2.dao.ImageDAO;
import net.feminaexlux.gallery.struts2.dao.UserDAO;
import net.feminaexlux.gallery.struts2.service.AlbumService;
import net.feminaexlux.gallery.struts2.service.ImageService;
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
	public AlbumDAO albumDAO() {
		return new AlbumDAO();
	}

	@Bean
	public ImageDAO imageDAO() {
		return new ImageDAO();
	}

	@Bean
	public UserDAO userDAO() {
		return new UserDAO();
	}

	@Bean
	@Scope("prototype")
	public AlbumService albumService() {
		return new AlbumService();
	}

	@Bean
	@Scope("prototype")
	public ImageService imageService() {
		return new ImageService();
	}

	@Bean
	@Scope("prototype")
	public UserService userService() {
		return new UserService();
	}
}
