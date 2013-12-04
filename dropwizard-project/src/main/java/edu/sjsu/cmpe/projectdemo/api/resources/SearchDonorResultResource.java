package edu.sjsu.cmpe.projectdemo.api.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.QueryParam;

import com.yammer.dropwizard.views.View;

import edu.sjsu.cmpe.projectdemo.dao.DatabaseConnection;
//import edu.sjsu.cmpe.projectdemo.domain.BloodRequest;
import edu.sjsu.cmpe.projectdemo.domain.Donor;
import edu.sjsu.cmpe.projectdemo.domain.Email;
import edu.sjsu.cmpe.projectdemo.domain.RootPath;
import edu.sjsu.cmpe.projectdemo.views.EmailErrorView;
import edu.sjsu.cmpe.projectdemo.views.EmailSentView;
import edu.sjsu.cmpe.projectdemo.views.LoginView;
import edu.sjsu.cmpe.projectdemo.views.SearchDonorResultView;
//import edu.sjsu.cmpe.projectdemo.views.RegistrationView;
import edu.sjsu.cmpe.projectdemo.views.SearchDonorView;

@Path("/login/patient/SearchDonorResult")
public class SearchDonorResultResource
{
	//private DatabaseConnection db;
	//private ArrayList<String> donornames=new ArrayList<String>();
	public SearchDonorResultResource()
	{
	}
	
	@GET
	public SearchDonorResultView getDonorResult(@QueryParam("location") String location,@QueryParam("bloodgroup") String bloodgroup)
	{
	
		DatabaseConnection db= new DatabaseConnection();
		ArrayList<Donor> donors = db.getDonors(location,bloodgroup);	
		return new SearchDonorResultView(donors);
	}

	@POST
	public View sendEmail (@FormParam("Email") String Email) 
	{
		System.out.println("email is " + Email);
		String msgBody="A patient has requested for blood";
		String subjectMsg="Request for blood donation";
	
		try {
			new Email().sendEmail(Email, msgBody, subjectMsg);
		}
		catch (Exception e){
			return new EmailErrorView();
		}
		
		return new EmailSentView();
		
	}	
	
}
