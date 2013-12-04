package edu.sjsu.cmpe.projectdemo.api.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.yammer.dropwizard.views.View;

import edu.sjsu.cmpe.projectdemo.dao.DatabaseConnection;
import edu.sjsu.cmpe.projectdemo.domain.RootPath;
import edu.sjsu.cmpe.projectdemo.views.EmailErrorView;
import edu.sjsu.cmpe.projectdemo.views.EmailSentView;
import edu.sjsu.cmpe.projectdemo.views.EmailVerifiedView;
import edu.sjsu.cmpe.projectdemo.views.LoginView;
import edu.sjsu.cmpe.projectdemo.views.SystemErrorView;

@Path("/verify")
public class EmailVerifyResource
{
	public EmailVerifyResource()
	{
		
	}
	
	@GET
	public EmailSentView getEmailView()
	{
		return new EmailSentView();
	}
	
	
	
	@Path("/activate")
	@GET
	public View getVerifiedView(@QueryParam("activationLink") UUID activation_id)
	{
		//go to database and activate 
		DatabaseConnection db=new DatabaseConnection();
		int retValue=db.verifyKey(activation_id);
		if(retValue==1)
		{
			return new EmailVerifiedView();
		}
		else if(retValue==2)
		{
			return new EmailErrorView();
		}
		
		return new SystemErrorView();
		
	}
	
	@Path("/activate")
	@POST
	public Response goToLogin() throws URISyntaxException
	{
		URI uri=new URI("http://"+RootPath.rootPath+"/portal/login");
		return Response.seeOther(uri).build();
	}
	
	
}