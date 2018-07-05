package com.jaskaran.project2.Domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonFormat;

@Component
@Entity
@Table(name = "C_BLOG_COMMENT")
public class BlogComment 
{
	@Id
	private int blogcommentid;
	private String loginname;
	private int  blogid;
	private String comments;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date commentedDate;
	
	
	public int getBlogcommentid() {
		return blogcommentid;
	}
	public void setBlogcommentid(int blogcommentid) {
		this.blogcommentid = blogcommentid;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
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
	
}