package edu.sjsu.cmpe.projectdemo.api.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import edu.sjsu.cmpe.projectdemo.views.SurveyView;




@Path("/survey")
public class SurveyResource
{
	
	public SurveyResource()
	{
	
	}
	

	@GET
	public SurveyView getSurvey()
	{
		System.out.println("Inside getsurvey()");
		return new SurveyView();
	}
	

	/*	
	@POST
	//public Response verifyLogin(@QueryParam("Username") String Username, @QueryParam("Password") String Password) throws URISyntaxException
	public Response verifyLogin(@FormParam("Username") String Username, @FormParam("Password") String Password) throws URISyntaxException
	{
	
		dbtest db=new dbtest();
		URI uri=new URI("http://localhost:8080/portal/login/donor/clinics/");
		
		String password_db="";
		try {
			password_db = db.getPassword(Username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(password_db.equals(Password))
		{
			return Response.seeOther(uri).build();
			
		}
		else
		{
			return Response.status(401).entity("Username or password is wrong").build();
		}
		
	
	}
	
	
	*/
}
