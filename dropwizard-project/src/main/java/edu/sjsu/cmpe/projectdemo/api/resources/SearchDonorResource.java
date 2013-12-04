package edu.sjsu.cmpe.projectdemo.api.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import edu.sjsu.cmpe.projectdemo.dao.DatabaseConnection;
import edu.sjsu.cmpe.projectdemo.domain.Donor;
import edu.sjsu.cmpe.projectdemo.domain.RootPath;
import edu.sjsu.cmpe.projectdemo.views.LoginView;
import edu.sjsu.cmpe.projectdemo.views.SearchDonorResultView;
//import edu.sjsu.cmpe.projectdemo.views.RegistrationView;
import edu.sjsu.cmpe.projectdemo.views.SearchDonorView;

@Path("/login/patient")
public class SearchDonorResource
{
	public SearchDonorResource(){
	}
	
	
	@GET
	public SearchDonorView getDonor()
		{
			return new SearchDonorView();
		}
	
	
	@POST
	public Response getDonors(@FormParam("d1") String bloodgroup, @FormParam("d2") String location) throws URISyntaxException
	{
			
			location=location.replace(" ","%20");
			bloodgroup=bloodgroup.replace("+","%2b");
			bloodgroup=bloodgroup.replace("-","%2d");
			URI uri=new URI("http://"+RootPath.rootPath+"/portal/login/patient/SearchDonorResult?location="+location+"&bloodgroup="+bloodgroup);
			return Response.seeOther(uri).build();
			
	}

	@Path("/login/patient/home/SearchDonorResult")
	@GET
	public SearchDonorResultView getDonorResult(@QueryParam("location") String location,@QueryParam("bloodgroup") String bloodgroup)
	{
		
		DatabaseConnection db= new DatabaseConnection();
		ArrayList<Donor> donors = new ArrayList<Donor>();
		
		donors = db.getDonors(location, bloodgroup);
		return new SearchDonorResultView(donors);
		}

}
