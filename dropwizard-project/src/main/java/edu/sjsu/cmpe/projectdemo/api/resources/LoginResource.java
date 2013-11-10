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

import edu.sjsu.cmpe.projectdemo.domain.Donor;
import edu.sjsu.cmpe.projectdemo.domain.Login;
import edu.sjsu.cmpe.projectdemo.views.*;
import edu.sjsu.cmpe.projectdemo.dto.DonorDto;



@Path("/login")
public class LoginResource
{
	
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
	public Response verifyLogin(@FormParam("Username") String Username, @FormParam("Password") String Password) throws URISyntaxException
	{
	
		if(Password.equals("password"))
		{
			//return Response.seeOther(uri).build();
			return Response.status(401).entity("Username or password is correct").build();
		}
		else
		{
			return Response.status(401).entity("Username or password is wrong").build();
		}
		
	
	}
	
	
	
}
