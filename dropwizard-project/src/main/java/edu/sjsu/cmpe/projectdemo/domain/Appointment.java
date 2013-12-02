package edu.sjsu.cmpe.projectdemo.domain;

import java.util.Date;

import org.joda.time.DateTime;

public class Appointment {

	private Date appointmentSlot; 

	
	public void setAppointmentSlot (Date appointment){
		this.appointmentSlot = appointment;
	}
	
	public Date getAppointmentSlot (){
		return this.appointmentSlot;
	}
}
