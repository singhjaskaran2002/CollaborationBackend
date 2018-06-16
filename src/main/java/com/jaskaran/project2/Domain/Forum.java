package com.jaskaran.project2.Domain;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
@Entity
@Table(name = "C_FORUM")
public class Forum extends BaseDomain implements Serializable
{
	@Id
	private int forumid;
	private String email;
	private String forumtitle;
	private String forumcontent;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date forum_created_date;
	private int forumlikes;
	private char forumstatus;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getForumid() {
		return forumid;
	}
	public void setForumid(int forumid) {
		this.forumid = forumid;
	}
	public String getForumtitle() {
		return forumtitle;
	}

	public void setForumtitle(String forumtitle) {
		this.forumtitle = forumtitle;
	}

	public String getForumcontent() {
		return forumcontent;
	}
	public void setForumcontent(String forumcontent) {
		this.forumcontent = forumcontent;
	}
	public Date getForum_created_date() {
		return forum_created_date;
	}
	public void setForum_created_date(Date forum_created_date) {
		this.forum_created_date = forum_created_date;
	}
	public int getForumlikes() {
		return forumlikes;
	}
	public void setForumlikes(int forumlikes) {
		this.forumlikes = forumlikes;
	}

	public char getForumstatus() {
		return forumstatus;
	}
	public void setForumstatus(char forumstatus) {
		this.forumstatus = forumstatus;
	}
	
	
}
