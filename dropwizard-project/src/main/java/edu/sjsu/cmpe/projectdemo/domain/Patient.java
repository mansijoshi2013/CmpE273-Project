package edu.sjsu.cmpe.projectdemo.domain;

public class Patient
{
	private Login login;
	private String name;
	private String hospitalAdmitted;
	private String bloodNeeded;
	
	public void setLogin(Login login)
	{
		this.login=login;
	}
	public Login getLogin()
	{
		return login;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return this.name;
	}
	
	public void setHospitalAdmitted(String hospitalAdmitted)
	{
		this.hospitalAdmitted=hospitalAdmitted;
	}
	public String getHospitalAdmitted()
	{
		return this.hospitalAdmitted;
	}
	
	public void setBloodNeeded(String bloodNeeded)
	{
		this.bloodNeeded=bloodNeeded;
	}
	public String getBloodNeeded()
	{
		return this.bloodNeeded;
	}
}