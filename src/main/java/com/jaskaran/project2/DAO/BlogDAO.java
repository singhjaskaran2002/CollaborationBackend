package com.jaskaran.project2.DAO;

import java.util.List;
import org.springframework.stereotype.Component;
import com.jaskaran.project2.Domain.Blog;
import com.jaskaran.project2.Domain.BlogComment;

@Component
public interface BlogDAO 
{
	
	public boolean saveBlog(Blog blog);			
	public boolean updateBlog(Blog blog);	
	public boolean deleteBlog(int blogid);		
	public Blog getBlog(int blogid);		
	public boolean approveBlog(int blogid);		
	public boolean rejectBlog(int blogid);		
	public boolean incLikes(int blogid);
	public List<Blog> blogList();	
	
	
	
	/********************* related to blog comment ***************/
	
	public boolean saveBlogComment(BlogComment blogComment);	
	public List<BlogComment> blogCommentList(int blogid);
	public boolean deletecomment(int blogcommentid);
	public BlogComment getBlogComment(int blogcommentid);
	
}
