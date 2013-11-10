package edu.sjsu.cmpe.projectdemo.domain;

import com.fasterxml.jackson.annotation.*;

public class Login
{
	@JsonProperty("Username")
	private String userName;
	
	@JsonProperty("Password")
	private String password;
	
	public String getUserName()
	{
		return this.userName;
	}
	
	public void setUserName(String userName)
	{
		this.userName=userName;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public void setPassword(String password)
	{
		this.password=password;
	}

}