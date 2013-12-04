package edu.sjsu.cmpe.projectdemo.views;

import java.util.ArrayList;

import com.yammer.dropwizard.views.View;

import edu.sjsu.cmpe.projectdemo.domain.Appointment;

public class TimeView extends View{
	ArrayList<String> times=new ArrayList<String>();
		

	ArrayList <Appointment> appointment= new ArrayList<Appointment>();
	

	public TimeView(ArrayList<Appointment> appointment){
		
		super("/time.ftl");
		this.appointment=appointment;
		
	}

	public ArrayList<Appointment> getAppointment() {
		return appointment;
	}


	
}
