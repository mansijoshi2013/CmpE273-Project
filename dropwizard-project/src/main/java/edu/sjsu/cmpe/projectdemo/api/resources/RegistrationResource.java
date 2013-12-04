package edu.sjsu.cmpe.projectdemo.api.resources;

import java.net.URI;
import java.net.URISyntaxException;


import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.joda.time.DateTime;

import edu.sjsu.cmpe.projectdemo.dao.DatabaseConnection;
import edu.sjsu.cmpe.projectdemo.domain.Donor;
import edu.sjsu.cmpe.projectdemo.domain.Email;
import edu.sjsu.cmpe.projectdemo.domain.PasswordEncryption;
import edu.sjsu.cmpe.projectdemo.domain.RootPath;
import edu.sjsu.cmpe.projectdemo.views.LoginView;
import edu.sjsu.cmpe.projectdemo.views.RegistrationView;

@Path("/Registration")
public class RegistrationResource {
	
	private Random random = new SecureRandom();
	public RegistrationResource()
	{
	}
		
	@GET
	public RegistrationView getRegistration()
	{
		return new RegistrationView();
	}
		
	@POST
	public Response registerUser(@FormParam("Name") String Name,
			@FormParam("DateOfBirth") String DateOfBirth,
			@FormParam("BloodGroup") String BloodGroup,
			@FormParam("PhoneNumber") Long PhoneNumber,@FormParam("Email") String Email,
			@FormParam("Street") String Street,@FormParam("City") String City,
			@FormParam("State") String State,@FormParam("ZipCode") int Zipcode,
			@FormParam("UserName") String UserName,@FormParam("Password") String Password) throws URISyntaxException
	{	
		//Re-enter password can be done as client side validation.
		URI uri=new URI("http://"+RootPath.rootPath+"/portal/verify");
		
		
		//Pass data as donor object into dao 
		Donor donor=new Donor();
		donor.setName(Name);
		donor.setDateOfBirth(DateOfBirth);
		donor.setBloodGroup(BloodGroup);
		donor.setPhoneNumber(PhoneNumber);
		donor.setEmail(Email);
		donor.setState(State);
		donor.setStreet(Street);
		donor.setCity(City);
		donor.setZipCode(Zipcode);
		donor.setUserName(UserName);
		String passwordHash = PasswordEncryption.makePasswordHash(Password, Integer.toString(random.nextInt()));
		donor.setPassword(passwordHash);
		donor.setActivation_Id();
		donor.setVerified(false);
		
		DatabaseConnection db=new DatabaseConnection();
		int retValue=db.insertDonor(donor);
		
		if(retValue==1)
		{
			String msgBody="Click on the link below to activate your account \n" +"http://"+RootPath.rootPath+"/portal/verify/activate?activationLink="+donor.getActivation_Id();
			String subjectMsg="Activate your account";
			//new Email().sendEmail(Email, donor.getActivation_Id());
			new Email().sendEmail(Email, msgBody,subjectMsg);
			return Response.seeOther(uri).build();
		}
		else if(retValue==2)
		{
			return Response.status(400).entity("Username already in use").build();
		}
		else
		{
			return Response.status(400).entity("Email already in use").build();
		}
			
			
		
				
		}	
		
	

}
