package edu.sjsu.cmpe.projectdemo.api.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import edu.sjsu.cmpe.projectdemo.dao.DatabaseConnection;
import edu.sjsu.cmpe.projectdemo.domain.AllAppointments;
import edu.sjsu.cmpe.projectdemo.domain.Appointment;
import edu.sjsu.cmpe.projectdemo.domain.RootPath;
import edu.sjsu.cmpe.projectdemo.views.AppointmentView;
import edu.sjsu.cmpe.projectdemo.views.TimeConfirm;
import edu.sjsu.cmpe.projectdemo.views.TimeView;

import javax.ws.rs.QueryParam;

import com.twilio.sdk.TwilioRestException;

@Path("login/donor/clinics/appointments/")
public class AppointmentResource {

	static String apt_date;
	static String clinicname;
	static String userName;
	AllAppointments appointments;
	
	public AppointmentResource()	{
		appointments=new AllAppointments();
	}
		
	@GET
	public AppointmentView getAppointments(@QueryParam("clinicName") String clinicName,@QueryParam("username") String username)
	{
		clinicname=""+clinicName;
		userName=""+username;
		return new AppointmentView();
	}
	
	@POST
    public Response bookAppointment(@FormParam ("date") String date) throws URISyntaxException{
		apt_date=date;
		URI uri=new URI("http://"+RootPath.rootPath+"/portal/login/donor/clinics/appointments/time");
		return Response.seeOther(uri).build();
    }

	@GET
	@Path("time")
	public TimeView timeBook(){
	DatabaseConnection db=new DatabaseConnection();
	ArrayList<Appointment> appointment=new ArrayList<Appointment>();
	appointment=db.getTimeByDate(apt_date);
	return new TimeView(appointment);
		
	}
	
	@GET
	@Path("time/confirm")
	public TimeConfirm viewTime()
	{
		return new TimeConfirm();
		
	}
	@POST
	@Path("time")
	public Response makeAppointment(@FormParam("time") String time) throws URISyntaxException{
		Appointment appointment=new Appointment();
		appointment.setUserName(userName);
		appointment.setClinicName(clinicname);
		appointment.setDate(apt_date);
		appointment.setTime(time);
		
		//get phone number for user
		DatabaseConnection db=new DatabaseConnection();
		Long number=db.getNumber(userName);
		String num=number.toString();
		num="+1"+num;
		//insert appointment for user into db
		db.insertAppointment(appointment);
		//twilio to send message to user
		try {
			TwilioImplementation TI=new TwilioImplementation("+14086368748",clinicname,apt_date,time);
		} catch (TwilioRestException e) {
			
			e.printStackTrace();
		}
		//redirects to user home page
		URI uri=new URI("http://"+RootPath.rootPath+"/portal/login/donor/home?username="+userName);
		return Response.seeOther(uri).build();
	}
	
	
}

