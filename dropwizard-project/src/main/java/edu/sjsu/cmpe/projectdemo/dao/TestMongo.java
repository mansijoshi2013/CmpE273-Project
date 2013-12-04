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
      
       /*
       BasicDBObject camp = new BasicDBObject();
       DBCollection campsCollection = database.getCollection("camps");
       
		camp.append("event_name","SJSU Annual Blood Drive")
		.append("venue","Dudley Morris Hall, San Jose State University")
		.append("city","San Jose").append("state", "CA").append("zip",95112)
		.append("dateOfEvent", "12/10/2013")
		.append("timeOfEvent","11:00 to 18:00");
     
		campsCollection.insert(camp);
		
		System.out.println(campsCollection.count());*/
		
      /*
       Set<String> colls = database.getCollectionNames();

       for (String s : colls) {
       System.out.println(s);
       }
       */
       
       DBCollection collection = database.getCollection("appointments");
    //  DBObject query=new BasicDBObject("userName" , "shweta");
      // DBObject obj=collection.findOne(query);
       //System.out.println(obj.toString());
       //((BasicDBObject) query).append("blood group","B+");
      // DBCursor cur=collection.find(query);
     DBCursor cur=collection.find();
		while(cur.hasNext())		
		{
			for (int i = 0; i<cur.count(); i++)
			{
				DBObject obj=cur.next();
				//System.out.println(obj.toString());
				collection.remove(obj);
			}
		}
       System.out.println(cur.count());
		/*
       DBCollection usersCollection = database.getCollection("camps");
       //DBObject query=new BasicDBObject("$oid","529d0a507939ded9e067c3e5");
       DBObject obj = (DBObject) usersCollection.findOne();
		usersCollection.remove(obj);
		*/
		//System.out.println(obj.toString());

      /* DBCollection usersCollection = database.getCollection("users");
		BasicDBObject admin = new BasicDBObject();
		admin.append("name","Admin").append("Username","admin").append("Password","password").append("user_type","admin");
        usersCollection.insert(admin);*/
    }
}

