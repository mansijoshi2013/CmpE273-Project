package edu.sjsu.cmpe.projectdemo.api.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import edu.sjsu.cmpe.projectdemo.views.AppointmentView;
import edu.sjsu.cmpe.projectdemo.views.TimeConfirm;
import edu.sjsu.cmpe.projectdemo.views.TimeView;


@Path("login/donor/clinics/appointments/")
public class AppointmentResource {

	static String apt_date;
	static String time;
	AllAppointments appointments;
	
	public AppointmentResource()	{
		appointments=new AllAppointments();
	}
		
	@GET
	public AppointmentView getAppointments()
	{
		return new AppointmentView();
	}
	
	@POST
    public Response bookAppointment(@FormParam ("date") String date) throws URISyntaxException{
		apt_date=date;
		URI uri=new URI("http://localhost:15000/portal/login/donor/clinics/appointments/time");
		return Response.seeOther(uri).build();
    }
	
	@GET
	@Path("time")
	public TimeView timeBook()
	{
		return new TimeView();
		
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
		appointment.setClinicName("Apollo");
		appointment.setDate(apt_date);
		appointment.setTime(time);
		DatabaseConnection db=new DatabaseConnection();
		db.insertAppointment(appointment);
		return Response.status(401).entity("Your appointment is booked on " + apt_date +"  at "+ time).build();
		
	}
}
