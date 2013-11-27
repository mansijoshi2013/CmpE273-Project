package edu.sjsu.cmpe.projectdemo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Patient extends User
{
	
	@JsonProperty("hospital_id")
	private String hospital_id;
	
	@JsonProperty("age")
	private int age;
	
	@JsonProperty("gender")
	private String gender;
	
	@JsonProperty("name")
	private String Name;
	
	@JsonProperty("blood group")
	private String bloodGroup;
	
	

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}


	
	public void setHospital_Id(String hospital_id)
	{
		this.hospital_id=hospital_id;
	}
	public String getHospital_Id()
	{
		return this.hospital_id;
	}
	
	
	public int getAge()
	{
		return this.age;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
	
	public String getGender()
	{
		return this.gender;
	}
	public void setGender(String gender)
	{
		this.gender=gender;
	}
	

}