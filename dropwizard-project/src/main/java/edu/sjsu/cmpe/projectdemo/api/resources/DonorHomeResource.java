package edu.sjsu.cmpe.projectdemo.api.resources;

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
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.fusesource.stomp.jms.StompJmsConnectionFactory;
import org.fusesource.stomp.jms.StompJmsDestination;
import org.fusesource.stomp.jms.message.StompJmsMessage;

import com.yammer.dropwizard.views.View;
import java.util.ArrayList;

import edu.sjsu.cmpe.projectdemo.dao.DatabaseConnection;
import edu.sjsu.cmpe.projectdemo.domain.Messaging;
import edu.sjsu.cmpe.projectdemo.domain.RequestConsumer;
import edu.sjsu.cmpe.projectdemo.views.DonorCampsView;
import edu.sjsu.cmpe.projectdemo.views.DonorHomeView;
import edu.sjsu.cmpe.projectdemo.domain.BloodRequest;

@Path("/login/donor/home")
public class DonorHomeResource {

	DatabaseConnection db;

	/*@GET
	public View displayCamps (){
		db  = new DatabaseConnection();
		
		//TODO 
		db.getCamps("San Jose");
		
		
		return new DonorCampsView();
	}*/
	
	@GET
	public View getDonorHomepage() 
	{
		//Consumer code: receive blood Requests in the background
		int numThreads=1;
		ExecutorService executor=Executors.newFixedThreadPool(numThreads);
		ArrayList<Future<BloodRequest>> list=new ArrayList<Future<BloodRequest>>();
		
		Callable<BloodRequest> callable= new RequestConsumer();
		//Runnable backgroundTask=new RequestConsumer();
		System.out.println("About to submit background task");
		try
		{
			Future<BloodRequest> future=executor.submit(callable);
			list.add(future);
			//for(Future<BloodRequest> fut : list){
	            try {
	                System.out.println(future.get());
	            } 
	            catch(Exception e)
	            {
	            	System.out.println("Exception in DonorHomePage ");
	            	e.printStackTrace();
	            }
	       // }
			//executor.execute(backgroundTask);
		}
		catch(Exception e)
		{
			executor.shutdown();
			e.printStackTrace();
		}
    	
    	
		return new DonorHomeView();
	}
	
	
}
