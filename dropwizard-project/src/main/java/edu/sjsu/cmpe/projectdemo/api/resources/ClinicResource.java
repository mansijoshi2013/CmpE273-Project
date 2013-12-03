package edu.sjsu.cmpe.projectdemo.api.resources;


import javax.ws.rs.FormParam;

import freemarker.core.TemplateElement;
import freemarker.template.Template;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import edu.sjsu.cmpe.projectdemo.dao.DatabaseConnection;
import edu.sjsu.cmpe.projectdemo.domain.AllClinics;
import edu.sjsu.cmpe.projectdemo.domain.Clinic;
import edu.sjsu.cmpe.projectdemo.views.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;


@Path("/login/donor/clinics")
public class ClinicResource
{
	ArrayList<Clinic> clinicList=new ArrayList<Clinic>();
	public ClinicResource()
	{
		
	}
	
	@GET
	public ClinicView getClinics() throws UnknownHostException
	{
		DatabaseConnection db=new DatabaseConnection();
		ArrayList<Clinic> clinicList=new ArrayList<Clinic>();
		clinicList=db.getAllClinics();
		
		return new ClinicView(clinicList);
	}
	
	@POST
	public Response showAppointments (@FormParam("checkedValue")String clinicName) throws URISyntaxException{
		clinicName=clinicName.replace(" ","%20");
		URI uri=new URI("http://localhost:15000/portal/login/donor/clinics/appointments/?clinicName="+clinicName);
		return Response.seeOther(uri).build();
	}
}