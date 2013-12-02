package edu.sjsu.cmpe.projectdemo.api.resources;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.yammer.dropwizard.jersey.params.LongParam;
import com.yammer.dropwizard.views.View;

import edu.sjsu.cmpe.projectdemo.dao.DatabaseConnection;
import edu.sjsu.cmpe.projectdemo.domain.*;
import edu.sjsu.cmpe.projectdemo.views.AdminCampView;
import edu.sjsu.cmpe.projectdemo.views.AdminHomeView;
import edu.sjsu.cmpe.projectdemo.views.AdminRequestView;
import edu.sjsu.cmpe.projectdemo.views.RegistrationView;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.fusesource.stomp.jms.StompJmsConnectionFactory;
import org.fusesource.stomp.jms.StompJmsDestination;

@Path("/login/admin")
public class AdminResource {

	
	@GET
	public AdminHomeView getAdminHomeView()
	{
		return new AdminHomeView();
	}
	
	
	@POST
	public Response displayForms(@FormParam ("FormName") String formName) throws URISyntaxException
	{
		if (formName.equals("Create Blood Request")){
			URI uri =new URI("http://localhost:15000/portal/login/admin/bloodRequest");
			return Response.seeOther(uri).build();
		}
		else{
			URI uri =new URI("http://localhost:15000/portal/login/admin/bloodCamp");
			return Response.seeOther(uri).build();
		}

	}

	
	@Path("/bloodRequest")
	@GET
	public AdminRequestView getAdminRequestView()
	{
		return new AdminRequestView();
	}
	
	@Path("/bloodRequest")
	@POST	
	public void createRequest (@FormParam("BloodGroup") String bloodGroup,
			@FormParam("Hospital") String hospital,
			@FormParam("Address") String address,
			@FormParam("City") String city,
			@FormParam("State") String state,
			@FormParam("ZipCode") int zipCode,
			@FormParam("PhoneNumber") Long phoneNumber,
			@FormParam("TimeOfRequest") String timeOfRequest)
	{
	
		//BloodRequest bloodRequest = new BloodRequest();
		try {
			String user = Messaging.env("APOLLO_USER", "admin");
	    	String password = Messaging.env("APOLLO_PASSWORD", "password");
	    	//String host = env("APOLLO_HOST", "54.215.210.214");
	    	String host = Messaging.env("APOLLO_HOST", "54.219.156.168");
	    	int port = Integer.parseInt(Messaging.env("APOLLO_PORT", "61613"));
	    	String queue = "/queue/69676.portal.request";
	    	String destination = Messaging.arg(0, queue);

	    	StompJmsConnectionFactory factory = new StompJmsConnectionFactory();
	    	factory.setBrokerURI("tcp://" + host + ":" + port);

	    	Connection connection = factory.createConnection(user, password);
	    	connection.start();
	    	Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	    	Destination dest = new StompJmsDestination(destination);
	    	MessageProducer producer = session.createProducer(dest);
	    	producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

	    	System.out.println("Sending messages to " + queue + "..."); 
	    	
	    	String data = bloodGroup + ":" + hospital
    			    + ":" + address + ":" + city 
    			    + ":" + state + ":" + zipCode 
    			    + ":" + phoneNumber+ ":" + timeOfRequest;	    	
	    	
	    	TextMessage msg = session.createTextMessage(data);
	    	msg.setLongProperty("id", System.currentTimeMillis());
	    	producer.send(msg);    	
		} 
		catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

	@Path("/bloodCamp")
	@GET
	public AdminCampView getAdminCampsView()
	{
		return new AdminCampView();
	}
	
	@Path("/bloodCamp")
	@POST
	public void createBloodDrive (@FormParam("EventName") String eventName,
			@FormParam("Address") String address,
			@FormParam("City") String city,
			@FormParam("State") String state,
			@FormParam("ZipCode") int zipCode,
			@FormParam("DateOfEvent") String dateOfEvent,
			@FormParam("TimeOfEvent") String timeOfEvent
			)
	{
		BloodDonationCamps camp = new BloodDonationCamps();
		camp.setCity(city);
		camp.setDateOfEvent(dateOfEvent);
		camp.setEventName(eventName);
		camp.setState(state);
		camp.setTimeOfEvent(timeOfEvent);
		camp.setVenue(address);
		camp.setZipCode(zipCode);
		
		DatabaseConnection db = new DatabaseConnection();
		db.insertCamps(camp);
		
	}
}
