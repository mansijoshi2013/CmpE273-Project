package edu.sjsu.cmpe.projectdemo.api.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import edu.sjsu.cmpe.projectdemo.views.LoginView;
import edu.sjsu.cmpe.projectdemo.views.RegistrationView;

@Path("/Registration")
public class RegistrationResource {
	
	public RegistrationResource(){
	}
		@GET
		public RegistrationView getRegistration()
		{
			return new RegistrationView();
		}
		
		@POST
		
		public Response verifyLogin(@FormParam("Name") String Name,@FormParam("DateOfBirth") String DateOfBirth,@FormParam("BloodGroup") String BloodGroup,@FormParam("PhoneNumber") String PhoneNumber,@FormParam("Email") String Email,@FormParam("Street") String Street,@FormParam("City") String City,@FormParam("State") String State,@FormParam("ZipCode") String Zipcode,@FormParam("UserName") String UserName,@FormParam("Password") String Password,@FormParam("Re-Enter Password") String repassword) throws URISyntaxException
		{	

				URI uri=new URI("http://localhost:8080/portal/login");
				return Response.seeOther(uri).build();
				
		}	
		
	

}
