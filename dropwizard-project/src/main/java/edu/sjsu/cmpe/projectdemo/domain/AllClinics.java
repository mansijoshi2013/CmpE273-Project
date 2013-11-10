package edu.sjsu.cmpe.projectdemo.domain;

import java.util.ArrayList;

public class AllClinics
{
	private static ArrayList<Clinic> clinics;
	
	static
	{
		clinics=new ArrayList<Clinic>();
	}
	
	public ArrayList<Clinic> getClinics()
	{
		return this.clinics;
	}
	
	public void setClinics(ArrayList<Clinic> clinics)
	{
		this.clinics=clinics;
	}
}