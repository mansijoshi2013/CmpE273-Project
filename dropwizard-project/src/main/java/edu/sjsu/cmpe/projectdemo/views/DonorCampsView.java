package edu.sjsu.cmpe.projectdemo.views;

import java.util.ArrayList;

import com.yammer.dropwizard.views.View;

import edu.sjsu.cmpe.projectdemo.domain.AllCamps;
import edu.sjsu.cmpe.projectdemo.domain.BloodDonationCamps;

public class DonorCampsView extends View{

	private ArrayList<BloodDonationCamps> camps = AllCamps.allCamps;
	public DonorCampsView() {
		super("DonorCamps.ftl");
		//camps = 
		
	}
	
	public ArrayList<BloodDonationCamps> getCamps() {
		return camps;
	}	

	
}
