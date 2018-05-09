package com.jaskaran.project2.Domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "C_JOB_APPLICATION")
public class JobApplication 
{
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int jobappid;
	private String email;
	private int jobid;
	private Date applied_date;
	private char jobappstatus;
	private String reason;
	
	
	public int getJobappid() {
		return jobappid;
	}
	public void setJobappid(int jobappid) {
		this.jobappid = jobappid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public Date getApplied_date() {
		return applied_date;
	}
	public void setApplied_date(Date applied_date) {
		this.applied_date = applied_date;
	}
	public char getJobappstatus() {
		return jobappstatus;
	}
	public void setJobappstatus(char jobappstatus) {
		this.jobappstatus = jobappstatus;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
