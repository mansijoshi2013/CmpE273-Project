package edu.sjsu.cmpe.projectdemo.api.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import edu.sjsu.cmpe.projectdemo.dao.DatabaseConnection;


@Path("/login/donor/home")
public class DonorHomeResource {

	DatabaseConnection db;

	@GET
	public Response displayCamps (){
		db  = new DatabaseConnection();
		
		//TODO 
		db.getCamps("San Jose");
		
		return Response.status(401).build();
	}
}
