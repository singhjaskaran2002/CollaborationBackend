package com.jaskaran.project2.Domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "C_PROFILE")
public class Profile 
{
	@Id
	private String email;
	private byte[] profilepicture;
	private String username;
	
	public byte[] getProfilepicture() {
		return profilepicture;
	}
	public void setProfilepicture(byte[] profilepicture) {
		this.profilepicture = profilepicture;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
