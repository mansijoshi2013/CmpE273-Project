package edu.sjsu.cmpe.projectdemo.api.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.yammer.dropwizard.jersey.params.LongParam;

import edu.sjsu.cmpe.projectdemo.domain.BloodRequest;

import javax.ws.rs.core.MediaType;
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
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdminResource {


	@POST	
	public void getRequest (BloodRequest bloodRequest) {
				
		try {
			createNewBloodRequest(bloodRequest);
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}
	
    public void createNewBloodRequest(BloodRequest bloodRequest) throws JMSException {
    	String user = env("APOLLO_USER", "admin");
    	String password = env("APOLLO_PASSWORD", "password");
    	//String host = env("APOLLO_HOST", "54.215.210.214");
    	String host = env("APOLLO_HOST", "54.219.156.168");
    	int port = Integer.parseInt(env("APOLLO_PORT", "61613"));
    	String queue = "/queue/69676.portal.request";
    	String destination = arg(0, queue);

    	StompJmsConnectionFactory factory = new StompJmsConnectionFactory();
    	factory.setBrokerURI("tcp://" + host + ":" + port);

    	Connection connection = factory.createConnection(user, password);
    	connection.start();
    	Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    	Destination dest = new StompJmsDestination(destination);
    	MessageProducer producer = session.createProducer(dest);
    	producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

    	System.out.println("Sending messages to " + queue + "..."); 
    	String data = bloodRequest.getBloodGroup() + ":" + bloodRequest.getHospital()
    			    + ":" + bloodRequest.getAddress() + ":" + bloodRequest.getCity() 
    			    + ":" + bloodRequest.getState() + ":" + bloodRequest.getZipCode() + ":" + bloodRequest.getPhoneNumber();
    	
    	TextMessage msg = session.createTextMessage(data);
    	msg.setLongProperty("id", System.currentTimeMillis());
    	producer.send(msg);    	
    	connection.close();
    }
    
    private static String env(String key, String defaultValue) {
		String rc = System.getenv(key);
		if( rc== null ) {
		    return defaultValue;
		}
		return rc;
    }

    private static String arg(int index, String defaultValue) {
	    return defaultValue;
    }

}
