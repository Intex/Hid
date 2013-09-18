package hid.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {

	@Bean
	public BasicDataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		dataSource.setUrl("jdbc:hsqldb:file:${webroot}/hiddb;shutdown=true");
		dataSource.setUsername("SA");
		dataSource.setPassword("");
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBuilder getSessionFactoryBuilder() {	
		LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(
				getDataSource());
		sessionFactoryBuilder.scanPackages("hid.entity.java");
		sessionFactoryBuilder.setProperty("hibernate.dialect",
				"org.hibernate.dialect.HSQLDialect");
		sessionFactoryBuilder.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		sessionFactoryBuilder.setProperty("hibernate.dbcp.initialSize", "1");
		sessionFactoryBuilder.setProperty("hibernate.show_sql", "true");
		sessionFactoryBuilder.setProperty("configurationClass", "org.hibernate.cfg.AnnotationConfiguration");
		return sessionFactoryBuilder;
	}

	@Bean(name = "sessionFactory" )
	public SessionFactory getSessionFactory() {
		return getSessionFactoryBuilder().buildSessionFactory();
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		return new HibernateTransactionManager(getSessionFactory());
	}
}