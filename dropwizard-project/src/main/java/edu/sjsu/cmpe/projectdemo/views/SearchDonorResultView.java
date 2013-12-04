package edu.sjsu.cmpe.projectdemo.views;

import java.util.ArrayList;

import com.yammer.dropwizard.views.View;

import edu.sjsu.cmpe.projectdemo.domain.Donor;


public class SearchDonorResultView extends View
{
	private ArrayList<Donor> donors = new ArrayList<Donor>();
	
	public SearchDonorResultView(ArrayList<Donor> donors)
	{
		super("searchdonorresult.ftl");
		this.donors=donors;
		
	}
	
	public ArrayList<Donor> getDonors(){
		return this.donors;
	}
}
