package edu.sjsu.cmpe.projectdemo.dto;

import edu.sjsu.cmpe.projectdemo.domain.Donor;

public class DonorDto {

	private Donor donor;
	
	public DonorDto (Donor donor){
		this.donor = donor;
	}
	
	public Donor getDonor(){
		return donor;
	}
	
	public void setDonor (Donor donor){
		this.donor = donor;
	}
}
