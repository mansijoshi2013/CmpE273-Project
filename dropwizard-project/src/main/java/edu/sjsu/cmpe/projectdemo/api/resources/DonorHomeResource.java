package edu.sjsu.cmpe.projectdemo.api.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.fusesource.stomp.jms.StompJmsConnectionFactory;
import org.fusesource.stomp.jms.StompJmsDestination;
import org.fusesource.stomp.jms.message.StompJmsMessage;

import com.yammer.dropwizard.views.View;

import java.util.ArrayList;
import javax.ws.rs.FormParam;

import edu.sjsu.cmpe.projectdemo.dao.DatabaseConnection;
import edu.sjsu.cmpe.projectdemo.domain.Appointment;
import edu.sjsu.cmpe.projectdemo.domain.BloodDonationCamps;
import edu.sjsu.cmpe.projectdemo.domain.Clinic;
import edu.sjsu.cmpe.projectdemo.domain.Messaging;
import edu.sjsu.cmpe.projectdemo.domain.RequestConsumer;
import edu.sjsu.cmpe.projectdemo.views.ClinicView;
import edu.sjsu.cmpe.projectdemo.views.DonorCampsView;
import edu.sjsu.cmpe.projectdemo.views.DonorHomeView;
import edu.sjsu.cmpe.projectdemo.domain.BloodRequest;

@Path("/login/donor/home")
public class DonorHomeResource {

	private DatabaseConnection db;
	ArrayList<BloodRequest> bloodRequests=new ArrayList<BloodRequest>();
	ArrayList<BloodDonationCamps> camp = new ArrayList<BloodDonationCamps>();
	ArrayList<Appointment> appointment=new ArrayList<Appointment>();
	static String userName;
	
	/*@GET
	public View displayCamps (){
		db  = new DatabaseConnection();
		
		//TODO 
		db.getCamps("San Jose");
		
		
		return new DonorCampsView();
	}*/
	
	@GET
	public View getDonorHomepage(@QueryParam("userName") String userName) 
	{
		this.userName=""+userName;
		//Consumer code: receive blood Requests in the background
		int numThreads=1;
		ExecutorService executor=Executors.newFixedThreadPool(numThreads);
		Runnable backgroundTask=new RequestConsumer();
		System.out.println("About to submit background task");
		try
		{
			executor.execute(backgroundTask);
		}
		catch(Exception e)
		{
			executor.shutdown();
			e.printStackTrace();
		}
		
		// fetch blood requests for the day
		db=new DatabaseConnection();
		bloodRequests=db.getBloodRequests();

		
		//CAMPS
		System.out.println(userName);
		db  = new DatabaseConnection();
		camp = db.getCamps(userName);
		
		db  = new DatabaseConnection();
		try{
		appointment = db.getAppointments(userName);
		}
		catch(NullPointerException e){
			return new DonorHomeView(userName,camp,bloodRequests);
		}
		
		return new DonorHomeView(userName,camp,bloodRequests,appointment);
		
		}
	@POST
	public Response viewClinics() throws URISyntaxException{
		URI uri=new URI("http://localhost:15000/portal/login/donor/clinics?username="+userName);
		return Response.seeOther(uri).build();
		
		
	}

	
}
