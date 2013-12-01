package edu.sjsu.cmpe.projectdemo.domain;

import org.joda.time.DateTime;

public class BloodRequest {

	private String bloodGroup;
	private String hospital;
	private String address;
	private String city;
	private String state;
	private int zipCode;
	private long phoneNumber;
	private DateTime timeOfRequest;

    
    public DateTime getTimeOfRequest() {
            return timeOfRequest;
    }
    public void setTimeOfRequest(DateTime timeOfRequest) {
            this.timeOfRequest = timeOfRequest;
    }

	
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
	
}
