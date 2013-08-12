package net.feminaexlux.gallery.struts2.configuration;

import com.mysql.jdbc.Driver;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class ORM {
	@Bean
	public EntityManagerFactory entityManagerFactory() throws SQLException {
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.setDataSource(dataSource());
		lcemfb.setJpaDialect(new HibernateJpaDialect());
		lcemfb.setJpaVendorAdapter(jpaVendorAdapter());
		lcemfb.setPersistenceUnitName("gallery-struts2");
		lcemfb.setPersistenceXmlLocation("classpath:persistence.xml");
		lcemfb.afterPropertiesSet();
		return lcemfb.getObject();
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setShowSql(true);
		jpaVendorAdapter.setDatabase(Database.MYSQL);
		return jpaVendorAdapter;
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager annotationDrivenTransactionManager() throws SQLException {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());
		return jpaTransactionManager;
	}

	@Bean
	public SessionFactory sessionFactory() throws SQLException {
		// wire up a session factory
		AnnotationSessionFactoryBean asFactoryBean = new AnnotationSessionFactoryBean();
		asFactoryBean.setDataSource(dataSource());
		// additional config
		return asFactoryBean.getObject();
	}

	@Bean
	public DataSource dataSource() throws SQLException {
		return new SimpleDriverDataSource(new Driver(), "jdbc:mysql://Tianne:3306/gallery", "gallery", "gallery");
	}

	@Bean
	public AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor() {
		return new AutowiredAnnotationBeanPostProcessor();
	}

	@Bean
	public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor() {
		return new PersistenceAnnotationBeanPostProcessor();
	}
}
