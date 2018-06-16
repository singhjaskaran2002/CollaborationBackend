package com.jaskaran.project2.Domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
@Entity
@Table(name = "C_BLOG")
public class Blog extends BaseDomain implements Serializable
{
	@Id
	private int blogid;
	private String blogtitle;
	private String user_created;		// email of the user who created this blog and it is referred from user table
	private String blogcontent;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date blogcreatedDate;
	private char blogstatus;
	private String blogremarks;
	private int bloglikes;	
	
	public int getBlogid() {
		return blogid;
	}
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	public String getBlogtitle() {
		return blogtitle;
	}
	public void setBlogtitle(String blogtitle) {
		this.blogtitle = blogtitle;
	}
	public String getUser_created() {
		return user_created;
	}
	public void setUser_created(String user_created) {
		this.user_created = user_created;
	}
	public String getBlogcontent() {
		return blogcontent;
	}
	public void setBlogcontent(String blogcontent) {
		this.blogcontent = blogcontent;
	}
	public Date getBlogcreatedDate() {
		return blogcreatedDate;
	}
	public void setBlogcreatedDate(Date blogcreatedDate) {
		this.blogcreatedDate = blogcreatedDate;
	}
	public char getBlogstatus() {
		return blogstatus;
	}
	public void setBlogstatus(char blogstatus) {
		this.blogstatus = blogstatus;
	}
	public String getBlogremarks() {
		return blogremarks;
	}
	public void setBlogremarks(String blogremarks) {
		this.blogremarks = blogremarks;
	}
	public int getBloglikes() {
		return bloglikes;
	}
	public void setBloglikes(int bloglikes) {
		this.bloglikes = bloglikes;
	}

}
