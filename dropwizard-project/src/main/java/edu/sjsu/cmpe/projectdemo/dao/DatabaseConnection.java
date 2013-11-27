package edu.sjsu.cmpe.projectdemo.dao;

import java.net.UnknownHostException;
import java.util.UUID;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;


import edu.sjsu.cmpe.projectdemo.domain.AllCamps;
import edu.sjsu.cmpe.projectdemo.domain.BloodDonationCamps;
import edu.sjsu.cmpe.projectdemo.domain.Donor;
import edu.sjsu.cmpe.projectdemo.domain.Patient;
import edu.sjsu.cmpe.projectdemo.domain.User;

public class DatabaseConnection {
	public static MongoClient client ;
	public static DB portalDatabase;
	
	public  DatabaseConnection(){
	    try {
			client = new MongoClient(new ServerAddress("54.215.197.26", 27017));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}    
	    portalDatabase = client.getDB("portal");
    }
	
	//To verify a login attempt
	public User verifyLogin(String Username,String Password)
	{
		DBCollection collection=portalDatabase.getCollection("users");
		DBObject query=new BasicDBObject("Username",Username).append("Password",Password);
		DBObject obj=collection.findOne(query);
		if(obj!=null)
		{
			String user_type=(String)obj.get("user_type");
			if(user_type.equals("donor"))
			{
				Donor donor=new Donor();
				donor.setName((String)obj.get("name"));
				donor.setUser_Type((String)obj.get("user_type"));
				return donor;
				
			}
			else 
			{
				Patient patient=new Patient();
				patient.setUser_Type((String)obj.get("user_type"));
				patient.setName((String)obj.get("name"));
				return patient;
			}
				
		}
		else
		{
			Donor nullDonor=new Donor();
			nullDonor.setUser_Type("NotFound");;
			return nullDonor;
			
		}
	}
	
	//To Register a User
	public void insertDonor(Donor donor)
	{
		DBCollection collection=portalDatabase.getCollection("users");
		
		BasicDBObject obj=new BasicDBObject();
		obj.put("name",donor.getName());
		
		obj.put("blood group", donor.getBloodGroup());
		obj.put("phoneNumber", donor.getPhoneNumber());
		obj.put("email", donor.getEmail());
		obj.put("State", donor.getState());
		obj.put("Street", donor.getStreet());
		obj.put("City", donor.getCity());
		obj.put("zipcode", donor.getZipCode());
		obj.put("Username", donor.getUserName());
		obj.put("Password", donor.getPassword());
		obj.put("user_type", "donor");
		obj.put("activation_id", donor.getActivation_Id());
		obj.put("verified", donor.getVerified());
		
		collection.insert(obj);
		
	}
	
	//To verify activation key
	public int verifyKey(UUID activation_id)
	{
		DBObject obj;
		DBCollection collection=portalDatabase.getCollection("users");
		DBObject query=new BasicDBObject("activation_id",activation_id);
		
		DBCursor cur=collection.find(query);
		if(cur.hasNext())
		{
			obj=cur.next();
			boolean verified=(Boolean)obj.get("verified");
			if(verified==false)
			{
				collection.update(new BasicDBObject("activation_id",activation_id), new BasicDBObject("$set",new BasicDBObject("verified","true")));
				return 1;
			}
			else
			{
				//Already verified account
				return 2;
			}
		}
		else
		{
			//invalid link
			return 3;
		}
	
	}
	
	public void getCamps (String city){
		BloodDonationCamps camp = new BloodDonationCamps();
		DBObject obj;
		DBCollection collection=portalDatabase.getCollection("camps");
		DBObject query = new BasicDBObject("city",city);
		
		DBCursor cur=collection.find(query);
		if(cur.hasNext())
		{
			obj=cur.next();
			camp.setCity(city);
			camp.setEventName((String) obj.get("event_name"));
			camp.setVenue((String) obj.get("venue"));
			camp.setState((String) obj.get("state"));
			camp.setZipCode((Integer) obj.get("zip"));
			
			AllCamps.allCamps.add(camp);
		}		
	}
			
}
