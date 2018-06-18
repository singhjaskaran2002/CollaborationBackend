package com.jaskaran.project2.DAO;

import org.springframework.stereotype.Component;

import com.jaskaran.project2.Domain.Profile;

@Component
public interface ProfileDAO 
{
	public boolean uploadProfile(Profile Profile);
	public Profile getProfile(String loginname);
	
}
