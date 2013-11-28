package edu.sjsu.cmpe.projectdemo.domain;

import java.security.Security;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

public class Email
{
	public void sendEmail(String email,UUID activation_id)
	{
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		final String SSL_FACTORY="javax.net.ssl.SSLSocketFactory";
		
		Properties props=System.getProperties();
		props.setProperty("mail.smtps.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port","465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.debug", "false");
		props.setProperty("mail.smtps.quitwait", "false");
		
		Session session=Session.getInstance(props,new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication("project.cmpe273","sjsucmpe273");
			}
		});
		session.setDebug(true);
		
		String msgBody="Click on the link below to activate your account \n" +"http://localhost:15000/portal/verify/activate?activationLink="+activation_id;
		try
		{
			
			String recipient=email;
			final MimeMessage msg=new MimeMessage(session);
			msg.setFrom(new InternetAddress("project.cmpe273@gmail.com"));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient,false));
			msg.setSubject("Activate your account");
			msg.setText(msgBody);
			SMTPTransport t=(SMTPTransport)session.getTransport("smtp");
			t.connect("smtp.gmail.com","project.cmpe273" ,"sjsucmpe273");
			t.sendMessage(msg, msg.getAllRecipients());
			System.out.println("Email sent");
			t.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}