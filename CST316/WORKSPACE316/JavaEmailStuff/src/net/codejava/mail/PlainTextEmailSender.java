package net.codejava.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class PlainTextEmailSender 
{

	public void sendPlainTextEmail(String host, String port,
			final String userName, final String password, String toAddress,
			String subject, String message) throws AddressException,
			MessagingException 
	{

		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() 
		{
			public PasswordAuthentication getPasswordAuthentication() 
			{
				return new PasswordAuthentication(userName, password);
			}
		};

		Session session = Session.getInstance(properties, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		// set plain text message
		msg.setText(message);

		// sends the e-mail
		Transport.send(msg);

	}
	
	/**
	 * Test the send e-mail method
	 *
	 */
	public static void main(String[] args) 
	{
		// SMTP server information
		String host = "smtp.gmail.com";
		String port = "587";
		String mailFrom = "hqpham@asu.edu";
		String password = "mypassword";

		// outgoing message information
		String mailTo = "hqpham@asu.edu";
		String subject = "Hello my friend";
		String message = "Hi Hieu, This is Java email testing 1,2,3...from Hieu Pham.";

		//Session session = Session.getInstance(props, new GMailAuthenticator(username, password));
		
		PlainTextEmailSender mailer = new PlainTextEmailSender();

		try 
		{
			mailer.sendPlainTextEmail(host, port, mailFrom, password, mailTo,
					subject, message);
			System.out.println("Email sent.");
		} 
		catch (Exception ex) 
		{
			System.out.println("Failed to sent email.");
			ex.printStackTrace();
		}
	}
}
