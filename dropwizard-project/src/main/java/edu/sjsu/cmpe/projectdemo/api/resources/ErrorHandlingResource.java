package edu.sjsu.cmpe.projectdemo.api.resources;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.yammer.dropwizard.views.View;

import edu.sjsu.cmpe.projectdemo.domain.RootPath;
import edu.sjsu.cmpe.projectdemo.views.WrongLoginView;

@Path("/error")
public class ErrorHandlingResource
{
	public ErrorHandlingResource()
	{
		
	}
	
	@Path("/login")
	@GET
	public View getLoginError()
	{
		return new WrongLoginView();
	}
	
	@Path("/login")
	@POST
	public Response goToHomePage() throws URISyntaxException
	{
		URI uri =new URI("http://"+RootPath.rootPath+"/portal/index");
		return Response.seeOther(uri).build();
	}
	
}