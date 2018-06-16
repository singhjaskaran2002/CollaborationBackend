package com.jaskaran.project2.Domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "C_BLOG_COMMENT")
public class BlogComment 
{
	@Id
	private int blogcommentid;
	private String email;
	private String username;
	private int  blogid;
	private String comments;
	private Date commentedDate;
	
	
	public int getBlogcommentid() {
		return blogcommentid;
	}
	public void setBlogcommentid(int blogcommentid) {
		this.blogcommentid = blogcommentid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBlogid() {
		return blogid;
	}
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getCommentedDate() {
		return commentedDate;
	}
	public void setCommentedDate(Date commentedDate) {
		this.commentedDate = commentedDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}