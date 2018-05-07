package com.jaskaran.project2.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jaskaran.project2.DAO.UserDAO;
import com.jaskaran.project2.Domain.User;

public class UserDAOTestCase 
{
	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static User user;
	
	@Autowired
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.jaskaran");
		context.refresh();
		userDAO = (UserDAO)context.getBean("userDAO");
		user = (User)context.getBean("user");
	}
	
	@Test
	public void addUserTestCase()
	{
		user.setUsername("Jaskaran Singh");
		user.setEmail("jaskaran@gmail.com");
		user.setMobile("9711131492");
		user.setPassword("jaskaran");
		user.setStatus('N');
		user.setRole('S');
		
		boolean flag = userDAO.saveUser(user);
		
		assertEquals("add user test case", true, flag);
	}
	
	
}
