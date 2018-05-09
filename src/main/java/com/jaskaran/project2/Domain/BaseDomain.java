package com.jaskaran.project2.Domain;

import javax.persistence.Transient;

public class BaseDomain 
{
	@Transient
	private String statusMessage;

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
}
