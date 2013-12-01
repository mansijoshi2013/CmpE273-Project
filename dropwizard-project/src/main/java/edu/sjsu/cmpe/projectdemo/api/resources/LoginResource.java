package edu.sjsu.cmpe.projectdemo.api.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import com.yammer.dropwizard.views.View;

import java.net.*;
import java.sql.SQLException;

import edu.sjsu.cmpe.projectdemo.dao.DatabaseConnection;
import edu.sjsu.cmpe.projectdemo.domain.Donor;
import edu.sjsu.cmpe.projectdemo.domain.Login;
import edu.sjsu.cmpe.projectdemo.domain.User;
import edu.sjsu.cmpe.projectdemo.views.*;
import edu.sjsu.cmpe.projectdemo.dto.DonorDto;



@Path("/login")
public class LoginResource
{
	DatabaseConnection db;
	
	public LoginResource()
	{
	
	}
	

	@GET
	public LoginView getLogin()
	{
		return new LoginView();
	}
	

	
	@POST
	//public Response verifyLogin(@QueryParam("Username") String Username, @QueryParam("Password") String Password) throws URISyntaxException
	public void verifyLogin(@FormParam("Username") String Username, @FormParam("Password") String Password) throws URISyntaxException
	{
	
		//URI uri=new URI("http://localhost:15000/portal/login/donor/home");
		URI uri=new URI("http://localhost:15000/portal/login/donor/clinics/appointments/");
		db=new DatabaseConnection();
		
		User user= db.verifyLogin(Username,Password);
		if(user.getUser_Type().equals("patient"))
		{
			//return Response.seeOther(uri).build();
			System.out.println("Its a patient.");
		}
		else if(user.getUser_Type().equals("donor"))
		{
			//return Response.seeOther(uri).build();
			System.out.println("Its a donor");
		}
		else
		{
			System.out.println("Username/password not found");
		}
		//return Response.seeOther(uri).build();
		
		
	
	}
	
	@Path("/login/donor/home")
	@GET
	public View displayCamps (){
		db  = new DatabaseConnection();
		
		//TODO 
		db.getCamps("San Jose");
		
		return new DonorCampsView();
	}
	
}
