package com.jaskaran.project2.test;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.jaskaran.project2.DAO.BlogDAO;
import com.jaskaran.project2.Domain.Blog;
import com.jaskaran.project2.Domain.BlogComment;

public class BlogDAOTestCase 
{
	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static BlogDAO blogDAO;
	
	@Autowired
	private static Blog blog;
	
	@Autowired
	private static BlogComment blogComment;
		
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.jaskaran");
		context.refresh();
		blogDAO = (BlogDAO)context.getBean("blogDAO");
		blog = (Blog)context.getBean("blog");
		blogComment = (BlogComment) context.getBean("blogComment");
	}

	@Test
	public void blogAddTest()
	{
		blog.setUser_created("singhjaskaran@gmail.com");
		blog.setBlogtitle("JAVA");
		blog.setBlogcontent("it is for java only");
		
		assertEquals("add blog test case", true, blogDAO.saveBlog(blog));
	}
	
	@Test
	public void addBlogCommentTest()
	{
		blogComment.setBlogid(101);
		blogComment.setComments("good topic");
		
		assertEquals("blog comment add test case", true, blogDAO.saveBlogComment(blogComment));
	}
	
}
