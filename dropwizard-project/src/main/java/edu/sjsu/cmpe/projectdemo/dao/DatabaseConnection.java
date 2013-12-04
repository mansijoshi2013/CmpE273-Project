package edu.sjsu.cmpe.projectdemo.dao;

import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.ServerAddress;

import edu.sjsu.cmpe.projectdemo.domain.Appointment;
import edu.sjsu.cmpe.projectdemo.domain.BloodRequest;
import edu.sjsu.cmpe.projectdemo.domain.Clinic;


import edu.sjsu.cmpe.projectdemo.domain.AllCamps;
import edu.sjsu.cmpe.projectdemo.domain.BloodDonationCamps;
import edu.sjsu.cmpe.projectdemo.domain.Donor;
import edu.sjsu.cmpe.projectdemo.domain.PasswordEncryption;
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
		//DBObject query=new BasicDBObject("Username",Username).append("verified","true");
		DBObject query=new BasicDBObject("Username",Username);
		DBObject obj=collection.findOne(query);
		if(obj!=null)
		{
			if (obj.get("user_type").equals("admin"))
			{
				User user = new User();
				user.setUser_Type("admin");
				return user;
			}
			String hashedAndSalted=obj.get("Password").toString();
			try{
			String salt=hashedAndSalted.split(",")[1];
			
			
			if (hashedAndSalted.equals(PasswordEncryption.makePasswordHash(Password, salt)))
			{
				String user_type=(String)obj.get("user_type");
				if(user_type.equals("donor") && obj.get("verified").equals("true"))
				{
					Donor donor=new Donor();
					donor.setName((String)obj.get("name"));
					donor.setUser_Type((String)obj.get("user_type"));
					return donor;
					
				}
				else if(user_type.equals("patient"))
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
			catch(Exception e)
			{
				Donor nullDonor=new Donor();
				nullDonor.setUser_Type("NotFound");;
				return nullDonor;
			}
		}
		else
		{
			Donor nullDonor=new Donor();
			nullDonor.setUser_Type("NotFound");;
			return nullDonor;
			
		}
		return null;
		
	}
	
	//To Register a User
	public int insertDonor(Donor donor)
	{
		DBCollection collection=portalDatabase.getCollection("users");
		String username=donor.getUserName();
		DBObject query=new BasicDBObject("Username",username);
		DBObject donorObj=collection.findOne(query);
		if(donorObj==null)
		{
			try
			{
				BasicDBObject obj=new BasicDBObject();
				obj.put("name",donor.getName());
				obj.put("DateOfBirth",donor.getDateOfBirth());
				obj.put("blood group", donor.getBloodGroup());
				obj.put("phoneNumber", donor.getPhoneNumber());
				obj.put("_id", donor.getEmail());
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
				return 1;
			}
			
			catch (MongoException.DuplicateKey e) {
            System.out.println("Email already in use");
            return 3;
			}
		}
		else
		{
			System.out.println("Username already in use");
			return 2;
		}
		
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
	
	

	//To view all clinics
	public ArrayList<Clinic> getAllClinics()
	{
		ArrayList<Clinic> clinicList =new ArrayList<Clinic>();
		DBCollection collection=portalDatabase.getCollection("clinics");
		DBCursor cursor=collection.find();
		while(cursor.hasNext())
		{
			for(int i=0;i<cursor.count();i++)
			{
				DBObject obj=cursor.next();
				String clinicName=obj.get("name").toString();
				String clinicAddress=obj.get("address").toString();
				Clinic clinicObj=new Clinic();
				clinicObj.setClinicName(clinicName);
				clinicObj.setClinicAddress(clinicAddress);
				clinicList.add(clinicObj);
			}
			
		}
		
		return clinicList;
	}
	
	//To insert blood requests from consumer
	public void insertRequests(BloodRequest bloodRequest)
	{
		DBCollection collection=portalDatabase.getCollection("bloodRequests");
		BasicDBObject obj=new BasicDBObject();
		obj.put("bloodGroup",bloodRequest.getBloodGroup() );
		obj.put("hospital", bloodRequest.getHospital());
		obj.put("address", bloodRequest.getAddress());
		obj.put("city", bloodRequest.getCity());
		obj.put("state",bloodRequest.getState() );
		obj.put("zipcode", bloodRequest.getZipCode());
		obj.put("phoneNumber", bloodRequest.getPhoneNumber());
		obj.put("timeOfRequest", bloodRequest.getTimeOfRequest());
		
		collection.insert(obj);
	}
	
	//To retrieve blood requests based on date
	public ArrayList<BloodRequest> getBloodRequests()
	{
		ArrayList<BloodRequest> bloodRequests=new ArrayList<BloodRequest>();
		DBCollection collection=portalDatabase.getCollection("bloodRequests");
		DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		Date date=new Date();
		String todayDate=dateFormat.format(date);
		DBObject query=new BasicDBObject("timeOfRequest",todayDate);
		
		DBCursor cursor=collection.find(query);
		while(cursor.hasNext())
		{
			DBObject obj=cursor.next();
			BloodRequest req=new BloodRequest();
			req.setAddress(obj.get("address").toString());
			req.setBloodGroup(obj.get("bloodGroup").toString());
			req.setCity(obj.get("city").toString());
			req.setHospital(obj.get("hospital").toString());
			req.setPhoneNumber((Long)obj.get("phoneNumber"));
			req.setState(obj.get("state").toString());
			req.setTimeOfRequest(obj.get("timeOfRequest").toString());
			req.setZipCode((Integer)obj.get("zipcode"));
			bloodRequests.add(req);
		}
		return bloodRequests;
	}
	
	public ArrayList<BloodDonationCamps> getCamps (String userName){
		BloodDonationCamps camp = new BloodDonationCamps();
		ArrayList<BloodDonationCamps> camps = new ArrayList<BloodDonationCamps>();
		DBObject obj;
		DBCollection usersCollection=portalDatabase.getCollection("users");
		DBObject userQuery = new BasicDBObject("Username",userName);
		DBObject userObject=usersCollection.findOne(userQuery);
		String city = new String();
		city = (String) userObject.get("City");
		DBCollection collection=portalDatabase.getCollection("camps");
		BasicDBObject ref = new BasicDBObject();
		ref.put("city",Pattern.compile(".*"+city+".*", Pattern.CASE_INSENSITIVE));
		DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		String todayDate=dateFormat.format(new Date());
		ref.append("dateOfEvent",new BasicDBObject("$gte",todayDate));
		DBCursor cur=collection.find(ref);

		while(cur.hasNext())		
		{
			for (int i = 0; i<cur.count(); i++)
			{
				obj=cur.next();
				camp = new BloodDonationCamps();
				camp.setCity((String) obj.get("city"));
				camp.setEventName((String) obj.get("event_name"));
				camp.setVenue((String) obj.get("venue"));
				camp.setState((String) obj.get("state"));
				camp.setZipCode((Integer) obj.get("zipcode"));
				camp.setDateOfEvent((String) obj.get("dateOfEvent"));
				camp.setTimeOfEvent((String) obj.get("timeOfEvent"));
				camps.add(camp);
			}
		}		
		
		return camps;
	}
	
	public void insertCamps(BloodDonationCamps camp)
	{
		DBCollection collection=portalDatabase.getCollection("camps");
		BasicDBObject obj=new BasicDBObject();
		obj.put("event_name",camp.getEventName());
		obj.put("venue", camp.getVenue());
		obj.put("city", camp.getCity());
		obj.put("state",camp.getState() );
		obj.put("zipcode", camp.getZipCode());
		obj.put("dateOfEvent",camp.getDateOfEvent()); 
		obj.put("timeOfEvent", camp.getTimeOfEvent());
		
		collection.insert(obj);
		System.out.println(collection.getCount());
	}
	//to insert appointments into db
		public void insertAppointment(Appointment appointment) {
			DBCollection collection=portalDatabase.getCollection("appointments");
			BasicDBObject object=new BasicDBObject();
			object.put("userName", appointment.getUserName());
			object.put("clinicName",appointment.getClinicName());
			object.put("date", appointment.getDate());
			object.put("time", appointment.getTime());
			
			collection.insert(object);
			
		}
	public Appointment getAllAppointmentsByDate(Date date){
			Appointment appointment = new Appointment();
			DBObject obj;
			DBCollection collection=portalDatabase.getCollection("appointments");
			DBObject query = new BasicDBObject("Date",date);
			DBCursor cur=collection.find(query);
			if(cur.hasNext())
			{
				obj=cur.next();
				appointment.setClinicName((String) obj.get("clinicName"));
				appointment.setTime((String) obj.get("time"));
			}
			return appointment;
		

			
		}

	public ArrayList<Appointment> getAppointments(String userName) {

		ArrayList<Appointment> appointment=new ArrayList<Appointment>();
		DBCollection collection=portalDatabase.getCollection("appointments");
		DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		Date date=new Date();
		String todayDate=dateFormat.format(date);
		DBObject query=new BasicDBObject("timeOfRequest",todayDate);
		
		DBCursor cursor=collection.find(query);
		while(cursor.hasNext())
		{
			DBObject obj=cursor.next();
			Appointment apt=new Appointment();
			apt.setClinicName(obj.get("clinicName").toString());
			apt.setClinicName(obj.get("date").toString());
			apt.setClinicName(obj.get("time").toString());
			appointment.add(apt);
		}
		return appointment;
	}
	
	//reset password
	public int resetPswd(String email,String password)
	{
		DBCollection collection=portalDatabase.getCollection("users");
		DBObject query=new BasicDBObject("_id",email);
		DBObject obj=collection.findOne(query);
		if(obj!=null)
		{
			collection.update(query, new BasicDBObject("$set",new BasicDBObject("Password",password)));
			return 1;
		}
		return 2;
	}
		

}
