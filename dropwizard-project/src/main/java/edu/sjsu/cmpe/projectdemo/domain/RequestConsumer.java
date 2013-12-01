package edu.sjsu.cmpe.projectdemo.domain;

import java.util.concurrent.Callable;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.fusesource.stomp.jms.StompJmsConnectionFactory;
import org.fusesource.stomp.jms.StompJmsDestination;
import org.fusesource.stomp.jms.message.StompJmsMessage;

public class RequestConsumer implements Callable<BloodRequest>
{
	private String user;
	private String password;
	private String host;
	private int port;
	StompJmsConnectionFactory factory;
	Connection connection;
	Session session;
	Destination dest;
	MessageConsumer consumer;
	BloodRequest bloodRequest=null;
	
	public RequestConsumer()
	{
		this.user=Messaging.env("APOLLO_USER","admin");
		this.password=Messaging.env("APOLLO_PASSWORD","password");
		this.host=Messaging.env("APOLLO_HOST", "54.219.156.168");
		this.port = Integer.parseInt(Messaging.env("APOLLO_PORT", "61613"));
		String queue = "/queue/69676.portal.request";
    	String destination = Messaging.arg(0, queue);
    	
    	StompJmsConnectionFactory factory=new StompJmsConnectionFactory();
    	factory.setBrokerURI("tcp://"+host+":"+port);
    	
    	try{
    	this.connection=factory.createConnection(user,password);
    	connection.start();
    	this.session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    	this.dest=new StompJmsDestination(destination);
    	this.consumer=session.createConsumer(dest);
    	System.out.println("Waiting for messages from "+queue+"...");
    	}
    	catch(Exception e)
    	{
    		System.out.println("Exception in RequestConsumer constructor");
    		e.printStackTrace();
    	}
	}
	
	@Override
	public BloodRequest call() 
	{
		while(true)
    	{
    		try
    		{
    			Message msg=consumer.receive();
    			if(msg instanceof TextMessage)
    			{
    				String body=((TextMessage)msg).getText();
    				if("SHUTDOWN".equals(body))
    				{
    					break;
    				}
    				System.out.println("Receieved message: "+body);
    				
    				//Parse message
    				String[] parts=body.split(":",7);
    				bloodRequest=new BloodRequest();
    				bloodRequest.setBloodGroup(parts[0]);
    				bloodRequest.setHospital(parts[1]);
    				bloodRequest.setAddress(parts[2]);
    				bloodRequest.setCity(parts[3]);
    				bloodRequest.setState(parts[4]);
    				int zipCode=Integer.parseInt(parts[5]);
    				bloodRequest.setZipCode(zipCode);
    				long phoneNumber=Long.parseLong(parts[6]);
    				bloodRequest.setPhoneNumber(phoneNumber);
    				
    				
    				
    			}
    			else if(msg instanceof StompJmsMessage)
    			{
    				StompJmsMessage smsg=((StompJmsMessage) msg);
    				String body=smsg.getFrame().contentAsString();
    				if("SHUTDOWN".equals(body))
    				{
    					break;
    				}
    				System.out.println("Recieved message: "+body);
    			}
    			else
    			{
    				System.out.println("Unexpected message type: "+msg.getClass());
    			}
    		}
    		catch(Exception e)
    		{
    			System.out.println("Exception in consuming message");
    			e.printStackTrace();
    		}
    		return bloodRequest;
    		
    	}
    	try {
			connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return bloodRequest;
    	
	}
}