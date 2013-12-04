package edu.sjsu.cmpe.projectdemo.views;

import java.util.ArrayList;

import com.yammer.dropwizard.views.View;

import edu.sjsu.cmpe.projectdemo.domain.AllCamps;
import edu.sjsu.cmpe.projectdemo.domain.Appointment;
import edu.sjsu.cmpe.projectdemo.domain.BloodDonationCamps;
import edu.sjsu.cmpe.projectdemo.domain.BloodRequest;

public class DonorHomeView extends View
{
	private ArrayList<BloodDonationCamps> camps = new ArrayList<BloodDonationCamps>();	
	private ArrayList<BloodRequest> bloodRequests=new ArrayList<BloodRequest>();
	private ArrayList<Appointment> appointment=new ArrayList<Appointment>();
	private String userName;
	
	public DonorHomeView(String userName,ArrayList<BloodDonationCamps> camps,ArrayList<BloodRequest> bloodRequests,ArrayList<Appointment> appointment)
	{
		
		super("DonorHome.ftl");
		this.camps = camps;
		this.bloodRequests=bloodRequests;
		this.appointment=appointment;
		this.userName=userName;
	}
	
	public ArrayList<BloodDonationCamps> getCamps() {
		return camps;
	}
	
	public ArrayList<BloodRequest> getBloodRequests()
	{
		return this.bloodRequests;
	}
	public ArrayList<Appointment> getAppointments()
	{
		return appointment;
	}
	public String getuserName(){
		return this.userName;
	}
}