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
	
	public void createInitialData(){
	
		
		usersCollection = portalDatabase.getCollection("users");
		BasicDBObject user = new BasicDBObject();
		user.append("name","Ross Geller").append("hospital_id","D9NJ1").append("age",58)
		.append("gender","M").append("blood group","B-").append("user_type","patient");
		
		usersCollection.insert(user);
	
		BasicDBObject camp = new BasicDBObject();
		campsCollection = portalDatabase.getCollection("camps");
		camp.append("event_name","Connecting People")
		.append("venue","Dudley Morris Hall, San Jose State University, One Washington Square, San Jose, CA 95112");
		
		campsCollection.insert(camp);
		
    }

}