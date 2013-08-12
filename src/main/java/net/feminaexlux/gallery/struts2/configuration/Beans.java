package net.feminaexlux.gallery.struts2.configuration;

import net.feminaexlux.gallery.struts2.dao.ResourceDAO;
import net.feminaexlux.gallery.struts2.service.ResourceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Configuration
@Import({ORM.class})
public class Beans {
	@Bean
	public ResourceDAO resourceDAO() {
		return new ResourceDAO();
	}

	@Bean
	@Scope("prototype")
	public ResourceService resourceService() {
		return new ResourceService();
	}
}
