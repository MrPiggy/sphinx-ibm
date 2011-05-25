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

public class EmailNotification {  
    private CustomerMstr customerMstr;
    private GoodsSpace goodsSpace;
  
    private static final String DATE_FORMAT_NOW = "MM/dd/yyyy hh:mm";
    
    public void sendEmail(){
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
 
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
			throw new RuntimeException(e);
		}
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