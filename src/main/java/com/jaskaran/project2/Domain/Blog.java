package com.jaskaran.project2.Domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "C_BLOG")
public class Blog {
	
	private int blogid;
	private String blogtitle;
	private String email;
	private String blogdescription;
	private Date blogcreatedDate;
	private char blogstatus;
	private String blogremarks;
	private int bloglikes;
	private int blogunlikes;
	
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBlogdescription() {
		return blogdescription;
	}
	public void setBlogdescription(String blogdescription) {
		this.blogdescription = blogdescription;
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
	public int getBlogunlikes() {
		return blogunlikes;
	}
	public void setBlogunlikes(int blogunlikes) {
		this.blogunlikes = blogunlikes;
	}
	
	

}
