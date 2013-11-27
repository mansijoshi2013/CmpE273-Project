package edu.sjsu.cmpe.projectdemo.views;

import com.yammer.dropwizard.views.*;

import edu.sjsu.cmpe.projectdemo.domain.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.SQLException;

public class AppointmentView extends View{
	
	  public Date addHours(Date date, int hours)
	    {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.add(Calendar.HOUR, hours); 
	        return cal.getTime();
	    }
	  
	  public Date setSlot (int numDays){
		  
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(new Date());
		  int year = cal.get(Calendar.YEAR);
		  int month = cal.get(Calendar.MONTH);
		  int date = cal.get(Calendar.DATE)+numDays;
		  int hour = 10;
		  //cal.clear();
		  cal.set(year, month, date, hour, 00, 00);
		  return cal.getTime();
	  }
	  
	public AppointmentView(){
		super("Appointment.ftl");
		
		Appointment[] app = new Appointment[50];		
		Date appSlot = new Date();
		int index=0;
		
		for (int j = 1; j <= 5; j++){
			appSlot = setSlot(j);		
			for (int i = 0; i < 5; i++){
				app[index]=new Appointment();
				app[index].setAppointmentSlot(appSlot);
				appSlot = addHours(appSlot,2);				
				AllAppointments.appointments.add(app[index]);
				index++;
			}	
		}
	}
	
	public ArrayList<Appointment> getAppointments(){
		return AllAppointments.appointments;
	}
	
}
