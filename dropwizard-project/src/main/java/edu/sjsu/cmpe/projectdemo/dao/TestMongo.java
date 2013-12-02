package edu.sjsu.cmpe.projectdemo.dao;

import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.util.JSON;

public class TestMongo {

    public static void main( String[] args ) throws UnknownHostException 
    {
       MongoClient client = new MongoClient(new ServerAddress("54.215.197.26", 27017));
       
       DB database = client.getDB("portal");
       
       BasicDBObject camp = new BasicDBObject();
       DBCollection campsCollection = database.getCollection("camps");
       
		camp.append("event_name","SJSU Annual Blood Drive")
		.append("venue","Dudley Morris Hall, San Jose State University")
		.append("city","San Jose").append("state", "CA").append("zip",95112)
		.append("dateOfEvent", "12/10/2013")
		.append("timeOfEvent","11:00 to 18:00");
     
		campsCollection.insert(camp);
		
		System.out.println(campsCollection.count());
		
      /*
       Set<String> colls = database.getCollectionNames();

       for (String s : colls) {
       System.out.println(s);
       }
       */
       
       
       //DBCollection usersCollection = database.getCollection("camps");
      // DBObject query=new BasicDBObject("Username","shwetarameshk");
       //DBObject obj = usersCollection.findOne();
		//usersCollection.remove(obj);
		
		//System.out.println(obj.toString());
/*
       DBCollection usersCollection = database.getCollection("users");
		BasicDBObject admin = new BasicDBObject();
		admin.append("name","Admin").append("Username","admin").append("Password","password").append("user_type","admin");
        */
    }
}

