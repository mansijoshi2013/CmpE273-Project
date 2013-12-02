package edu.sjsu.cmpe.projectdemo.domain;

import java.util.Date;

import org.joda.time.DateTime;

public class Appointment {

	private String date;
	private String time;
	private String clinicName;
	
	public String getDate() {
		return date;
	}
	public void setDate(String apt_date) {
		this.date = apt_date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getClinicName() {
		return clinicName;
	}
	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}
	
}
