package edu.sjsu.cmpe.projectdemo.api.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;



import com.yammer.dropwizard.views.View;

import edu.sjsu.cmpe.projectdemo.views.*;




@Path("/index")
public class IndexResource
{
	

	@GET
	public IndexView getLogin()
	{
		return new IndexView();
	}

	@Path("/news")
	@GET()
	public View getNews()
	{
		return new NewsView();
	}


	@Path("/AboutUs")
	@GET
	public AboutUsView getAboutUs()
	{
		return new AboutUsView();
	}
}
