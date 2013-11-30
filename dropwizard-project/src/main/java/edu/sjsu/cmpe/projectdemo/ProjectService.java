package edu.sjsu.cmpe.projectdemo;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.views.ViewBundle;

import edu.sjsu.cmpe.projectdemo.api.resources.*;
import edu.sjsu.cmpe.projectdemo.config.ProjectServiceConfiguration;

public class ProjectService extends Service <ProjectServiceConfiguration>{

	public static void main (String[] args) throws Exception {
		new ProjectService().run(args);
	}
	
	@Override
	public void initialize(Bootstrap<ProjectServiceConfiguration> bootstrap) {
		bootstrap.setName("project-service");
		bootstrap.addBundle(new ViewBundle());

	}

	@Override
	public void run(ProjectServiceConfiguration configuration,
			Environment environment) throws Exception {

		environment.addResource(LoginResource.class);
		environment.addResource(ClinicResource.class);
		environment.addResource(RegistrationResource.class);
		environment.addResource(AppointmentResource.class);
		environment.addResource(EmailVerifyResource.class);
		//environment.addResource(DonorHomeResource.class);
		
		//environment.addResource(PortalResource.class);
		//environment.addResource(SurveyResource.class);
	    //environment.addResource(DonorDonateBloodResource.class);

	}
	
		
}
