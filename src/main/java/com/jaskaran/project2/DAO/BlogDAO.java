package com.jaskaran.project2.DAO;

import java.util.List;

import com.jaskaran.project2.Domain.Blog;

public interface BlogDAO 
{
	
	public boolean saveBlog(Blog blog);
	public boolean updateBlog(Blog blog);
	public Blog getBlog(int id);
	public List<Blog> blogList();
	
	//admin can accept/reject the blog
	//we can use update(Blog blog) method.
	
	//comment on a particular blog
	
	//one to many ->  N number of user can comment on
	//a particular blog.
	
}
