package edu.sjsu.cmpe.projectdemo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User
{
	@JsonProperty("user_type")
	private String user_type;
	
	
	
	public void setUser_Type(String user_type)
	{
		this.user_type=user_type;
	}
	
	public String getUser_Type()
	{
		return this.user_type;
	}
	
	


}