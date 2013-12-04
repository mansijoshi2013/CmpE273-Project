package edu.sjsu.cmpe.projectdemo.views;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.yammer.dropwizard.views.View;

import edu.sjsu.cmpe.projectdemo.domain.Appointment;

import org.apache.commons.collections.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections.iterators.AbstractListIteratorDecorator;
import org.apache.commons.collections.list.SetUniqueList;
import org.apache.commons.collections.set.UnmodifiableSet;
public class TimeView extends View{
	
	ArrayList <Appointment> appointment= new ArrayList<Appointment>();
	ArrayList <String> booked= new ArrayList<String>();
	ArrayList <String> available=new ArrayList<String>();
	ArrayList <String> slots=new ArrayList<String>();
	List l=new ArrayList();

	public TimeView(ArrayList<Appointment> appointment){
		
		super("/time.ftl");
		this.appointment=appointment;
		slots.add("9:00");
		slots.add("10:00");
		slots.add("11:00");
		slots.add("12:00");
		slots.add("1:00");
		slots.add("2:00");
		slots.add("3:00");
		slots.add("4:00");
		for(int i=0;i<appointment.size();i++)
		{
			booked.add(appointment.get(i).getTime());
		}
		if(booked.size()==0){
			for(int i=0;i<slots.size();i++)
				available.add(slots.get(i));
		}
		 
		for(int j=0;j<slots.size();j++)
		for(int i=0;i<booked.size();i++)
		if(!slots.get(j).equalsIgnoreCase(booked.get(i))){
			System.out.print("slot is"+slots.get(j)+"booked is:"+booked.get(i)+"are not equal");
			available.add(slots.get(j));
		}
		Set set = new HashSet(); 
		 l =SetUniqueList.decorate(available);
		for(int j=0;j<l.size();j++)
		System.out.print("\n\nAvaliable slots are:::"+l.get(j));
	}

	public ArrayList<String> getBooked() {
		return booked;
	}
	
	public List<String> getAvailable() {
		return l;
	}

	
	public List getL() {
		return l;
	}

	public void setL(List l) {
		this.l = l;
	}

	public ArrayList<Appointment> getAppointment() {
		return appointment;
	}


	
}
