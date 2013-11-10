package edu.sjsu.cmpe.projectdemo.domain;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Donor {
	
	@JsonProperty("Name")
	private String Name;
	@JsonProperty("DateOfBirth")
	private DateTime DateOfBirth;
	@JsonProperty("BloodGroup")
	private String bloodGroup;
	@JsonProperty("PhoneNumber")
	private long phoneNumber;
	@JsonProperty("Email")
	private String Email;
	@JsonProperty("Street")
	private String Street;
	@JsonProperty("City")
	private String City;
	@JsonProperty("State")
	private String State;
	@JsonProperty("ZipCode")
	private int ZipCode;
	@JsonProperty("UserName")
	private String UserName;
	@JsonProperty("Password")
	private String Password;

	
	private Login donorLogin;

	public String getName() {
		return Name;
	}




	public void setName(String name) {
		Name = name;
	}




	public DateTime getDateOfBirth() {
		return DateOfBirth;
	}




	public void setDateOfBirth(DateTime dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}




	public String getBloodGroup() {
		return bloodGroup;
	}




	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}




	public long getPhoneNumber() {
		return phoneNumber;
	}




	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}




	public String getEmail() {
		return Email;
	}




	public void setEmail(String email) {
		this.Email = Email;
	}




	public String getStreet() {
		return Street;
	}




	public void setStreet(String street) {
		Street = street;
	}




	public String getCity() {
		return City;
	}




	public void setCity(String city) {
		City = city;
	}




	public String getState() {
		return State;
	}




	public void setState(String state) {
		State = state;
	}




	public int getZipCode() {
		return ZipCode;
	}




	public void setZipCode(int zipCode) {
		ZipCode = zipCode;
	}




	public String getUserName() {
		return UserName;
	}




	public void setUserName(String username) {
		UserName = username;
	}




	public String getPassword() {
		return Password;
	}




	public void setPassword(String password) {
		Password = password;
	}


public Login getDonorLogin(){
	return this.donorLogin;
}

	public void updatePassword (String password){
	this.donorLogin.setPassword(password);
	}

	
	
}
