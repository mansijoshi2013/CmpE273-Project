package edu.sjsu.cmpe.projectdemo.views;

import com.yammer.dropwizard.views.*;
import edu.sjsu.cmpe.projectdemo.domain.*;
import java.util.ArrayList;


public class ClinicView extends View
{
	private ArrayList<Clinic> clinicList;
	
	public ClinicView(ArrayList<Clinic> clinicList)
	{
		//super("/clinicList.ftl");
		super("clinic.ftl");
		this.clinicList=clinicList;
		
	}
	
	public ArrayList<Clinic> getClinicList()
	{
		return this.clinicList;
	}
	
	public void setClinicList(ArrayList<Clinic> clinicList)
	{
		this.clinicList=clinicList;
	}
}