package edu.sjsu.cmpe.projectdemo.api.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.yammer.dropwizard.views.View;

import java.net.*;
import java.sql.SQLException;

import edu.sjsu.cmpe.projectdemo.dao.DatabaseConnection;
import edu.sjsu.cmpe.projectdemo.domain.Donor;
import edu.sjsu.cmpe.projectdemo.domain.Login;
import edu.sjsu.cmpe.projectdemo.domain.User;
import edu.sjsu.cmpe.projectdemo.views.*;
import edu.sjsu.cmpe.projectdemo.dto.DonorDto;
import edu.sjsu.cmpe.projectdemo.domain.Email;



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
	public Response verifyLogin(@FormParam("Username") String Username, @FormParam("Password") String Password) throws URISyntaxException
	{
	
		//URI uri=new URI("http://localhost:15000/portal/login/donor/home");
		URI uri =new URI("http://localhost:15000/portal/login");
		URI uriDonor=new URI("http://localhost:15000/portal/login/donor/home?userName="+Username);
		URI uriAdmin = new URI ("http://localhost:15000/portal/login/admin");
		
		db=new DatabaseConnection();
		
		User user= db.verifyLogin(Username,Password);
		
		if(user.getUser_Type().equals("patient"))
		{
			
			System.out.println("Its a patient.");
			return Response.seeOther(uri).build();
			
		}
		else if(user.getUser_Type().equals("donor"))
		{
			System.out.println("Its a donor");	
			return Response.seeOther(uriDonor).build();
		}
		else if(user.getUser_Type().equals("admin"))
		{
			System.out.println("Its the admin");	
			return Response.seeOther(uriAdmin).build();
		}
		else
		{
			System.out.println("Username/password not found");			
			//return Response.seeOther(uri).build();
			return Response.status(200).entity(new SystemErrorView()).build();
		}
		//return Response.seeOther(uri).build();	
	}
	
	@Path("/ForgotPassword")
	@GET
	public View getForgotPasswordPage()
	{
		return new ForgotPasswordView();
	}
	
	@Path("/ForgotPassword")
	@POST
	public void sendEmailForgotPassword(@FormParam("Email") String Email)
	{
		DatabaseConnection db=new DatabaseConnection();
		String msgBody="Click on the link to reset your password: \n "+ "http://localhost:15000/portal/login/ResetPassword?email="+Email;
		String subjectMsg="Reset your password";
		new Email().sendEmail(Email, msgBody, subjectMsg);
	}
	
	@Path("/ResetPassword")
	@GET
	public void getPasswordResetView(@QueryParam("email") String email)
	{
		
	}
	
}
