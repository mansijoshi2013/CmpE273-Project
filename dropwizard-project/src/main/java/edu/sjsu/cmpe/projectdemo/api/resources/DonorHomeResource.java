package edu.sjsu.cmpe.projectdemo.api.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.yammer.dropwizard.views.View;

import edu.sjsu.cmpe.projectdemo.dao.DatabaseConnection;
import edu.sjsu.cmpe.projectdemo.views.DonorCampsView;

@Path("/login/donor/home")
public class DonorHomeResource {

	DatabaseConnection db;

	@GET
	public View displayCamps (){
		db  = new DatabaseConnection();
		
		//TODO 
		db.getCamps("San Jose");
		
		return new DonorCampsView();
	}
}
