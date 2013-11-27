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

import edu.sjsu.cmpe.projectdemo.domain.AllClinics;
import edu.sjsu.cmpe.projectdemo.domain.Clinic;
import edu.sjsu.cmpe.projectdemo.views.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;


@Path("/login/donor/clinics/")
public class ClinicResource
{
	AllClinics clinics;
	
	public ClinicResource()
	{
		clinics=new AllClinics();
	}
	
	@GET
	public ClinicView getClinics()
	{
		return new ClinicView();
	}
	
	@POST
	public Response chooseAppointmentDate(@FormParam ("checkedValue") String clinicName) throws URISyntaxException{
		URI uri = new URI("http://localhost:15000/portal/login/donor/clinics/appointments/");
		
		return Response.seeOther(uri).build();
	}
	
}