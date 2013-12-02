package edu.sjsu.cmpe.projectdemo.domain;

import java.util.Date;
import java.util.UUID;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Donor extends User{
	
	@JsonProperty("DateOfBirth")
	private String DateOfBirth;
	
	@JsonProperty("PhoneNumber")
	private long phoneNumber;
	
	@JsonProperty("email")
	private String Email;
	
	@JsonProperty("Street")
	private String Street;
	
	@JsonProperty("City")
	private String City;
	
	@JsonProperty("State")
	private String State;
	
	@JsonProperty("zipcode")
	private int ZipCode;
	
	@JsonProperty("UserName")
	private String UserName;
	
	@JsonProperty("Password")
	private String Password;
	
	@JsonProperty("name")
	private String Name;
	
	@JsonProperty("blood group")
	private String bloodGroup;
	
	@JsonProperty("activation_id")
	private UUID activation_id;
	
	@JsonProperty("verified")
	private boolean verified=false;
	

	public UUID getActivation_Id()
	{
		return this.activation_id;
	}
	
	public void setActivation_Id()
	{
		this.activation_id=UUID.randomUUID();
	}
	
	public void setVerified(boolean verified)
	{
		this.verified=verified;
	}
	
	public boolean getVerified()
	{
		return this.verified;
	}

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


	
	
	private Login donorLogin;

	
	public String getDateOfBirth() {
		return DateOfBirth;
	}

    public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
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
		this.Email = email;
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
