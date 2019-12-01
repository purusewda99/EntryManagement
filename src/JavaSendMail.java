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

public class JavaSendMail {
	public static void sendMail(String recepientEmail,String subject,String body) throws MessagingException
	{
		Properties p = new Properties();
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "587");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable", "true");
		
		String senderAccountEmail = "test.m4922@gmail.com";
		String senderAccountPassword = "@Test4922!";
		
		Session s = Session.getInstance(p, new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(senderAccountEmail,senderAccountPassword);
			}
		});
		
		Message message = prepareMessage(s,senderAccountEmail,recepientEmail,subject,body);
		Transport.send(message);
	}

	private static Message prepareMessage(Session s, String senderAccountEmail, String recepientEmail, String subject, String body) {
		Message m = new MimeMessage(s);
		try {
			m.setFrom(new InternetAddress(senderAccountEmail));
			m.setRecipient(Message.RecipientType.TO, new InternetAddress(recepientEmail));
			m.setSubject(subject);
			m.setText(body);
			return m;
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
