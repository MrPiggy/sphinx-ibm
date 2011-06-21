package ssms.email;


import ssms.entities.CustomerMstr;
import ssms.entities.GoodsSpace;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class EmailNotification {  
    private CustomerMstr customerMstr;
    private GoodsSpace goodsSpace;
  
    private static final String DATE_FORMAT_NOW = "MM/dd/yyyy hh:mm";
    private static final Logger logger = Logger.getLogger(EmailNotification.class);
    
    public void sendEmail(){
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		logger.info("Session initializing...");
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("sphinx.ibm","sphinx123");
				}
			});
		try {
			Calendar cal = Calendar.getInstance();
		    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		    
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("capstonesphinx@googlegroups.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(customerMstr.getCustemail()));
			message.setSubject("SSMS - Export Shipment Service Notification");
			message.setText("Dear " + customerMstr.getCustname() + "," +
					"\n\n Your last shipment that went out is "
					+ goodsSpace.getShipmentid() + " and your available free space as on " + sdf.format(cal.getTime()) +  " is " 
					+ customerMstr.getAvailablespace() + ". \n\n We appreciate your business. \n\n Thanks, \n\n ABC Corp.");
 
			Transport.send(message); 
		} catch (MessagingException e) {
			logger.error("Cannot send email: " + customerMstr.getCustemail());
			logger.error("Error in sending email: ", e);
			throw new RuntimeException(e);
		}
		logger.info("Email sent successfully.");
      }

	public CustomerMstr getCustomerMstr() {
		return customerMstr;
	}

	public void setCustomerMstr(CustomerMstr customerMstr) {
		this.customerMstr = customerMstr;
	}

	public GoodsSpace getGoodsSpace() {
		return goodsSpace;
	}

	public void setGoodsSpace(GoodsSpace goodsSpace) {
		this.goodsSpace = goodsSpace;
	}
}  