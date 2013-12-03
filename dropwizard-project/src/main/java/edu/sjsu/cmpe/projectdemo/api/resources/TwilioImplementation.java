package edu.sjsu.cmpe.projectdemo.api.resources;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Sms;
import com.twilio.sdk.resource.list.SmsList;
import java.util.HashMap;
import java.util.Map;

public class TwilioImplementation {

	 

	 
	  // Find your Account Sid and Token at twilio.com/user/account
	 public static final String ACCOUNT_SID = "ACc9fbd189acf5282ca07386e79b3c987d";
	  public static final String AUTH_TOKEN = "7198b94fc98368eda88d7d857e83f978";
	  
	public TwilioImplementation(String num,String clinic,String date,String time) throws TwilioRestException{
		
		 
	    TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
	 
	    // Build a filter for the SmsList
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("Body", "Your appointment has been confirmed at"+ clinic+" on "+date+"--"+time);
	    params.put("To", num);
	    params.put("From", "+16505674403");
	 
	    SmsFactory messageFactory = client.getAccount().getSmsFactory();
	    Sms message = messageFactory.create(params);
	    System.out.println(message.getSid());
	}
	  
	}
