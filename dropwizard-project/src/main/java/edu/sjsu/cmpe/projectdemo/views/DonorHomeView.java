package edu.sjsu.cmpe.projectdemo.views;

import java.util.ArrayList;

import com.yammer.dropwizard.views.View;

import edu.sjsu.cmpe.projectdemo.domain.AllCamps;
import edu.sjsu.cmpe.projectdemo.domain.BloodDonationCamps;

public class DonorHomeView extends View
{
	private ArrayList<BloodDonationCamps> camps = new ArrayList<BloodDonationCamps>();	
	public DonorHomeView(ArrayList<BloodDonationCamps> camps)
	{
		
		super("DonorHome.ftl");
		this.camps = camps;
	}
	
	public ArrayList<BloodDonationCamps> getCamps() {
		return camps;
	}	
}