package com.jaskaran.project2.DAO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jaskaran.project2.Domain.BlogComment;

@Component
public interface BlogCommentDAO 
{
	public BlogComment getBlogComment(int blogcommentid);
	public List<BlogComment> blogCommentList(int blogid);
	public boolean saveBlogComment(BlogComment blogComment);
	public boolean deleteBlogComment(int blogcommentid);
	public boolean updateBlogComment(BlogComment blogComment);
}
