package com.jaskaran.project2.Configuration;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.jaskaran")
@EnableTransactionManagement
public class ApplicationContextConfig 
{
		@Autowired
		@Bean(name = "dataSource")
		public DataSource getH2DataSource()
		{
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE"); //collaborationdb
			dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			dataSource.setUsername("collaborationdb"); //oracle username
			dataSource.setPassword("root"); //oracle passwordbb
			return dataSource;
		}
		
		private Properties getHibernateProperties() 
		{
			Properties properties = new Properties();
			//properties.put("hibernate.hbm2ddl.auto", "create");
			properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
			properties.put("hibernate.show_sql", "true");
			properties.put("hibernate.enable_lazy_load_no_trans", "true");
			return properties;
		}

		@Autowired
		@Bean(name = "sessionFactory")
		public SessionFactory getSessionFactory(DataSource dataSource) 
		{
			LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
			sessionBuilder.addProperties(getHibernateProperties());
			sessionBuilder.scanPackages("com.jaskaran");
			return sessionBuilder.buildSessionFactory();
		}
		
		@Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) 
		{
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
			return transactionManager;
		}
}