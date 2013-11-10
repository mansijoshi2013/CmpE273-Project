package edu.sjsu.cmpe.projectdemo.dao;

import java.net.UnknownHostException;
import java.util.Set;

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
       DBCollection collection = database.getCollection("clinics");
       
  
       String name = "shweta";
       DBObject dbObject = (DBObject) JSON.parse("{'name':\""+name+"\"}");
       collection.insert(dbObject);
       
       DBCursor document = collection.find();
       
       while (document.hasNext()){
    	   System.out.println(document.next().get("name").toString());   
       }
       
       System.out.println(document.count());
*/
        
    }
}

