package com.jaskaran.project2.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jaskaran.project2.DAO.ForumDAO;
import com.jaskaran.project2.Domain.Forum;

public class ForumDAOTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static ForumDAO forumDAO;
	
	@Autowired
	private static Forum forum;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.jaskaran");
		context.refresh();
		forumDAO = (ForumDAO)context.getBean("forumDAO");
		forum = (Forum)context.getBean("forum");
	}
	
	@Test
	public void addForumTest()
	{
		forum.setForumtitle("Spring");
		forum.setEmail("singhjaskaran@gmail.com");
		forum.setForumcontent("only Spring");
		
		assertEquals("add forum test case", true, forumDAO.saveForum(forum));
	}

}
