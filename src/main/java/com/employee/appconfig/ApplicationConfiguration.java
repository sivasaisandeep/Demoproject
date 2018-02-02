package com.employee.appconfig;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.employee.dao.EmployeeDao;
import com.employee.dao.EmployeeDaoImpl;
@Configuration
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(basePackages = "com.employee")
public class ApplicationConfiguration extends WebMvcConfigurerAdapter{
	//@Autowired
	//private Environment environment;
	@Bean
	public EmployeeDao getEmployeeDao() {
		return new EmployeeDaoImpl();
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.employee.entity" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.show_sql", false);
		properties.put("hibernate.format_sql", false);
		return properties;        
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/Demo");
		dataSource.setUsername("root");
		dataSource.setPassword("123456789");
		return dataSource;
	} 
	
	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	  public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/").setViewName("home");
	  }
}