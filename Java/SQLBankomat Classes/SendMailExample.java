
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

// Wichtig damit es funktioniert Google muss zugriff von 3 Anbieter apps zulassen.

public class SendMailExample {
	
	public String emailVersenden (String email) {
		Properties properties = new Properties();
		properties.put("mail.smtp.auth",  "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		String myAccount = "sanssolvanthd@gmail.com";
		String myPassword = "Zinedine88r";
		String empfaenger = email;
		String code = zufallsPasswort();

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccount, myPassword);
			}
		});

		// Message-Objekt erzeugen und senden!
		try {
			Message message = prepareMessage(session, myAccount, empfaenger, code);
			Transport.send(message); // E-Mail senden!
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return code;
	}

	public Message prepareMessage(Session session, String myAccount, String empfaenger, String code) throws Exception{
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(myAccount));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(empfaenger));
		message.setSubject("Pw Änderung");

		// Multipart-Message ("Wrapper") erstellen
		Multipart multipart = new MimeMultipart();
		// Body-Part setzen:
		BodyPart messageBodyPart = new MimeBodyPart();
		// Textteil des Body-Parts
		messageBodyPart.setText("Ihr Bestätigungscode: " + code + " geben Sie denn Code ins Gui ein, um Ihr Passwort zu ändern.");
		// Body-Part dem Multipart-Wrapper hinzufügen
		multipart.addBodyPart(messageBodyPart);
		// Message fertigstellen, indem sie mit dem Multipart-Content ausgestattet wird
		message.setContent(multipart);			
		return message;
	}
	
	public String zufallsPasswort() {
		ArrayList <String> zahlList = new ArrayList<String>();
		for (int i = 0; i < 8; i++) {
			String zahl = String.valueOf((int) (Math.random() * 10));
			zahlList.add(zahl);
			Random r = new Random();
			String c = String.valueOf((char)(r.nextInt(26) + 'A'));
			zahlList.add(c);
		}
		StringBuilder sb = new StringBuilder();
		for (String s : zahlList) {
		    sb.append(s);
		}
		String zahlFertig = sb.toString();
		return zahlFertig;
	}
}


