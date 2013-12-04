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
import edu.sjsu.cmpe.projectdemo.views.LoginView;
import edu.sjsu.cmpe.projectdemo.views.SearchDonorResultView;
//import edu.sjsu.cmpe.projectdemo.views.RegistrationView;
import edu.sjsu.cmpe.projectdemo.views.SearchDonorView;

@Path("/login/patient/home/SearchDonorResult")
public class SearchDonorResultResource
{
	public SearchDonorResultResource()
	{
	}
	
}	
