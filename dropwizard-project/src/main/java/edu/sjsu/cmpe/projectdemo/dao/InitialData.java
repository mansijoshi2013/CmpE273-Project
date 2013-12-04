package edu.sjsu.cmpe.projectdemo.dao;

import java.net.UnknownHostException;



import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class InitialData {

	private MongoClient client = DatabaseConnection.client;
	private DB portalDatabase = DatabaseConnection.portalDatabase;
	private DBCollection usersCollection;
	private DBCollection campsCollection;
	
	public void main(){

		
		usersCollection = portalDatabase.getCollection("users");
		BasicDBObject patient = new BasicDBObject();
		patient.append("name","Sheldon Cooper").append("Username","D9NJ1").append("age",30)
		.append("gender","M").append("blood group","B-").append("user_type","patient");
		
		usersCollection.insert(patient);
		
		/*
		BasicDBObject donor=new BasicDBObject();
		donor.append("name","Monica Geller").append("DateOfBirth","11/05/1980")
		.append("gender","F").append("blood group", "B-").append("email","monica_g@gmail.com")
		.append("zipcode","95014").append("State", "CA").append("City", "Cupertino")
		.append("Username","monica.geller").append("Password","monica123").append("user_type", "donor");
		
		usersCollection.insert(donor);
	
		BasicDBObject camp = new BasicDBObject();
		campsCollection = portalDatabase.getCollection("camps");
		camp.append("event_name","Connecting People")
		.append("venue","Dudley Morris Hall,San Jose State University, One Washington Square, ")
		.append("city","San Jose").append("state", "CA").append("zip",95112);
		
		campsCollection.insert(camp);
		*/
    }

}