package com.inter_chat.Inter_Chat_Backend.config;

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

import com.inter_chat.Inter_Chat_Backend.model.ApplyingJob;
import com.inter_chat.Inter_Chat_Backend.model.Blog;
import com.inter_chat.Inter_Chat_Backend.model.BlogComment;
import com.inter_chat.Inter_Chat_Backend.model.Forum;
import com.inter_chat.Inter_Chat_Backend.model.ForumComment;
import com.inter_chat.Inter_Chat_Backend.model.Friend;
import com.inter_chat.Inter_Chat_Backend.model.Job;
import com.inter_chat.Inter_Chat_Backend.model.ProfilePicture;
import com.inter_chat.Inter_Chat_Backend.model.UserDetail;


@Configuration
@ComponentScan("com.inter_chat.Inter_Chat_Backend")
@EnableTransactionManagement
public class DBConfig 
{
	@Bean(name="dataSource")
	public DataSource getOracleDataSource() 
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521/XE");
		dataSource.setUsername("INTERCHAT");
		dataSource.setPassword("pass123");
		System.out.println("Data Source Created");
		return dataSource;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory() 
	{
		Properties hibernateProperties = new Properties();
		
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		
		LocalSessionFactoryBuilder localsessionFactoryBuilder = new LocalSessionFactoryBuilder(getOracleDataSource());
		localsessionFactoryBuilder.addProperties(hibernateProperties);
		localsessionFactoryBuilder.addAnnotatedClass(ApplyingJob.class);
		localsessionFactoryBuilder.addAnnotatedClass(Blog.class);
		localsessionFactoryBuilder.addAnnotatedClass(BlogComment.class);
		localsessionFactoryBuilder.addAnnotatedClass(Forum.class);
		localsessionFactoryBuilder.addAnnotatedClass(ForumComment.class);
		localsessionFactoryBuilder.addAnnotatedClass(Friend.class);
		localsessionFactoryBuilder.addAnnotatedClass(Job.class);
		localsessionFactoryBuilder.addAnnotatedClass(UserDetail.class);
		localsessionFactoryBuilder.addAnnotatedClass(ProfilePicture.class);

		SessionFactory sessionFactory = localsessionFactoryBuilder.buildSessionFactory();
		System.out.println("Session Factory Created");
		return sessionFactory;
	}
	
	@Bean(name="transactionManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) 
	{
		System.out.println("Transaction Manager Created");
		return new HibernateTransactionManager(sessionFactory);
	}
}