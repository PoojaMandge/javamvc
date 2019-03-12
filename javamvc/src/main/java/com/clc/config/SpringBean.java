package com.clc.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
/*@Configuration
@PropertySource(value={"database.properties"})
//@EnableWebMvc
@ComponentScan({"com.clc.config"})
public class SpringBean {

	static {
		System.out.println("bean mvc class...");
	}
	
	@Value("${jdbc.driverClassName}")String driverClassName;
	@Value("${jdbc.url}")String dbUrl;
	@Value("${jdbc.username}")String dbUserName;
	@Value("${jdbc.password}")String Password;
	@Value("${hibernate.dialect}")String hbmDialectPropertyValue;
	@Value("${hibernate.show_sql}")String hbmShowSqlPropertyValue;
	@Value("${hibernate.format_sql}")String hbmFormatSqlPropertyValue;
	@Value("${hibernate.hbmddl}")String hbmDdlAutoPropertyValue;
	
	String hbmDialictProperty="hibernate.dialect";
	String hbmShowSqlProperty="hibernate.show_sql";
	String FormatSqlProperty="hibernate.format_sql";
	String DdlAutoProperty="hibernate.hbm2ddl.auto";
	  
	
	@Bean
	    public static PropertySourcesPlaceholderConfigurer  propertySourcesPlaceholderConfigurer() {
	
		return new PropertySourcesPlaceholderConfigurer();
	    }
	
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		System.out.println(hbmDialectPropertyValue);
		System.out.println(hbmDialectProperty);
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] {"com.clc.*"});
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
		
	}
	
	@Bean
	public DataSource dataSource() {
		System.out.println("Driver class name   !!!!!");
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(dbUserName);
		dataSource.setPassword(Password);
		return dataSource;
	}
	
	private Properties hibernateProperties() {
		Properties prop=new Properties();
		prop.put(hbmDialictProperty, hbmDialectPropertyValue);
		prop.put(hbmShowSqlProperty, hbmShowSqlPropertyValue);
		prop.put(FormatSqlProperty, hbmFormatSqlPropertyValue);
		prop.put(DdlAutoProperty, hbmDdlAutoPropertyValue);
		
		return prop;
		
	}
	
	
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/"); //emp
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    
}

*/







@Configuration  //it represetns this bean configurations -- bean.xml
@EnableWebMvc
@ComponentScan({ "com.clc.*" })//this represents base packageToScan <context:component-scan base-package="com.clc.*">
@PropertySource(value = { "classpath:database.properties" })//propertyplaceholder bean //<context:property-placeholder location="classpath:db.properties,app.properties" />
public class SpringBean {

	@Value("${jdbc.driverClassName}")String driverClassName;
	@Value("${jdbc.url}")String dbUrl;
	@Value("${jdbc.username}")String dbUserName;
	@Value("${jdbc.password}")String password;
	@Value("${hibernate.dialect}")String hbmDialectPropertyValue;
    @Value("${hibernate.show_sql}")String hbmShowSqlPropertyValue;
    @Value("${hibernate.format_sql}")String hbmFormatSqlPropertyValue;
    @Value("${hibernate.ddl}")String hbmDdlAutoPropertyValue;
	
    static{
    	System.out.println("Loading of BeanXMl");
    }
	String hbmDialectProperty = "hibernate.dialect";
    String hbmShowSqlProperty = "hibernate.show_sql";
    String hbmFormatSqlProperty = "hibernate.format_sql";
    String hbmDdlAutoProperty = "hibernate.hbm2ddl.auto";
    
    
    @Bean  //create object with new -- to spring container madhe add kara -- LocalsessionFactory
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.clc.*" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }
    @Bean
    public static PropertySourcesPlaceholderConfigurer  propertySourcesPlaceholderConfigurer() {
    	return new  PropertySourcesPlaceholderConfigurer();
    }
    @Bean  //create object with new -- to spring container madhe add kara -- BasicDataSource
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        System.out.println("driverClassName : "+driverClassName);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUserName);
        dataSource.setPassword(password);
        return dataSource;
    }
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put(hbmDialectProperty,  hbmDialectPropertyValue);
        properties.put(hbmShowSqlProperty,hbmShowSqlPropertyValue);
        properties.put(hbmFormatSqlProperty,hbmFormatSqlPropertyValue);
        properties.put(hbmDdlAutoProperty,hbmDdlAutoPropertyValue);
        return properties;        
    }
	
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/"); //emp
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    
}