package edu.sjsu.cmpe.projectdemo.views;

import java.util.ArrayList;

import com.yammer.dropwizard.views.View;

import edu.sjsu.cmpe.projectdemo.domain.AllCamps;
import edu.sjsu.cmpe.projectdemo.domain.BloodDonationCamps;
import edu.sjsu.cmpe.projectdemo.domain.BloodRequest;

public class DonorHomeView extends View
{
	private ArrayList<BloodDonationCamps> camps = new ArrayList<BloodDonationCamps>();	
	private ArrayList<BloodRequest> bloodRequests=new ArrayList<BloodRequest>();
	
	public DonorHomeView(ArrayList<BloodDonationCamps> camps,ArrayList<BloodRequest> bloodRequests)
	{
		
		super("DonorHome.ftl");
		this.camps = camps;
		this.bloodRequests=bloodRequests;
	}
	
	public ArrayList<BloodDonationCamps> getCamps() {
		return camps;
	}
	
	public ArrayList<BloodRequest> getBloodRequests()
	{
		return this.bloodRequests;
	}
}