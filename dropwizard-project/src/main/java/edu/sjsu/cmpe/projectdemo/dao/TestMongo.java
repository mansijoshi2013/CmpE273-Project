package edu.sjsu.cmpe.projectdemo.dao;

import java.net.UnknownHostException;
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
     
       
       Set<String> colls = database.getCollectionNames();

       for (String s : colls) {
       System.out.println(s);
       }
       

       /*
       DBCollection usersCollection = database.getCollection("users");
		BasicDBObject admin = new BasicDBObject();
		admin.append("name","Admin").append("Username","admin").append("Password","password").append("user_type","admin");
        */
    }
}

