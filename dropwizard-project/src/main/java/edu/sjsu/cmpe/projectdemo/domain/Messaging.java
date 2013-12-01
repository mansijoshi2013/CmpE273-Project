package edu.sjsu.cmpe.projectdemo.domain;

public class Messaging
{
	public static String env(String key, String defaultValue) {
		String rc = System.getenv(key);
		if( rc== null ) {
		    return defaultValue;
		}
		return rc;
    }

    public static String arg(int index, String defaultValue) {
	    return defaultValue;
    }
}