package edu.sjsu.cmpe.projectdemo.views;

import com.yammer.dropwizard.views.View;

public class EmailVerifiedView extends View
{
	public EmailVerifiedView()
	{
		super("/EmailVerified.ftl");
	}
}