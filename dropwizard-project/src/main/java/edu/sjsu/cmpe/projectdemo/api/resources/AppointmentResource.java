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

import edu.sjsu.cmpe.projectdemo.domain.AllAppointments;
import edu.sjsu.cmpe.projectdemo.views.AppointmentView;
import edu.sjsu.cmpe.projectdemo.views.TimeView;


@Path("login/donor/clinics/appointments/")
public class AppointmentResource {

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
	public Response bookAppointment(@FormParam ("checkedValue") String bookedSlot) throws URISyntaxException{
		
		Date date = new Date();
		try {
			date = new SimpleDateFormat("MMM d, yyyy HH:mm:ss a").parse(bookedSlot);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(401).entity("Your appointment is booked at " + bookedSlot).build();
	}
	
	@GET
	@Path("time")
	public TimeView timeBook()
	{
		return new TimeView();
		
	}
}
