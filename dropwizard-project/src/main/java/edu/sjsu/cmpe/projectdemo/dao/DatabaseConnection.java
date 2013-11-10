package edu.sjsu.cmpe.projectdemo.dao;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

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
}
