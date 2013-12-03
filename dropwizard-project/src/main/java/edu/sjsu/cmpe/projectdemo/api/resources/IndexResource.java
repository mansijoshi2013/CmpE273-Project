package edu.sjsu.cmpe.projectdemo.api.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


import edu.sjsu.cmpe.projectdemo.views.*;




@Path("/index")
public class IndexResource
{
	

	@GET
	public IndexView getLogin()
	{
		return new IndexView();
	}
	

	
	
	
}
