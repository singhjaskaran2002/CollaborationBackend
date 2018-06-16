package com.jaskaran.project2.DAO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jaskaran.project2.Domain.Blog;

@Component
public interface BlogDAO 
{
	
	public boolean saveBlog(Blog blog);			// saving a blog
	public boolean updateBlog(Blog blog);		// updating blog
	public boolean deleteBlog(int blogid);		// deleting the blog
	public Blog getBlog(int blogid);			//	getting the blog details
	public List<Blog> approvedBlogsList(); 		// getting the list of approved blogs
	public boolean approveBlog(int blogid);		//	to approve the blog
	public boolean rejectBlog(int blogid);		// to reject the blog
	public boolean incLikes(int blogid);
	public List<Blog> blogList();		
}
