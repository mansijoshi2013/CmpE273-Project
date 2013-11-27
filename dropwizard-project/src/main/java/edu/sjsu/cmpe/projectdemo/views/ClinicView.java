package edu.sjsu.cmpe.projectdemo.views;

import com.yammer.dropwizard.views.*;
import edu.sjsu.cmpe.projectdemo.domain.*;
import java.util.ArrayList;

public class ClinicView extends View
{
	private ArrayList<Clinic> sample;
	Clinic clinic1,clinic2;
	private int length;
	
	public ClinicView()
	{
		super("ClinicTrial.ftl");
		sample=new ArrayList<Clinic>();
		clinic1=new Clinic();
		clinic2=new Clinic();
		clinic1.setClinicName("Apollo Clinic  ");
		clinic1.setClinicAddress("123 N 4th Street, San Jose 95112");
		sample.add(clinic1);
		clinic2.setClinicName("Cupertino HealthCare  ");
		clinic2.setClinicAddress("420 Homestead Rd, Cupertino 95014");
		sample.add(clinic2);
	}
	
	public ArrayList<Clinic> getSample()
	{
		return this.sample;
	}
	
	public int getLength()
	{
		this.length=sample.size();
		return this.length;
	}
}