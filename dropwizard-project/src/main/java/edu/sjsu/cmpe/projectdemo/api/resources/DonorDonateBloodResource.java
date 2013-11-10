package edu.sjsu.cmpe.projectdemo.api.resources;

import java.net.URI;
import java.net.URISyntaxException;



import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import edu.sjsu.cmpe.projectdemo.views.DonorOnSuccessfulLoginView;
//import edu.sjsu.cmpe.projectdemo.views.LoginView;


@Path("/donateblood")
public class DonorDonateBloodResource
{
	
	public DonorDonateBloodResource()
	{
	
	}
	
	
	@GET
	public DonorOnSuccessfulLoginView getView()
	{
		return new DonorOnSuccessfulLoginView();
	}
	

	
	@POST
	public Response verifyLogin() throws URISyntaxException//@QueryParam("Username") String Username, @QueryParam("Password") String Password) throws URISyntaxException
	//public Response verifyLogin(@FormParam("Username") String Username, @FormParam("Password") String Password) throws URISyntaxException
	{
		URI uri=new URI("http://localhost:8080/portal/survey");
		/*
		String name="abc";
		String pswd="abc";
		if(Username.equals(name) && Password.equals(pswd))
		{
			return Response.seeOther(uri).build();
			
		}
		else
		{
		*/
			//return Response.status(401).entity("Please answer the questions coming up to donate blood").build();
		//}
		return Response.seeOther(uri).build();
	}
	
	
	
} 