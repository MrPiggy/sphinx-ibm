/**
 * 
 */
package pagecode;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.component.UINamingContainer;
import javax.faces.component.html.HtmlOutputText;
import ssms.entities.CustomerMstr;
import ssms.entities.controller.CustomerMstrManager;
import com.ibm.jpa.web.JPA;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlMessages;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

/**
 * @author ManMan
 *
 */
public class AddCustomer extends PageCodeBase {

	private static final Logger logger = Logger.getLogger(AddCustomer.class);
	
	protected HtmlPanelGrid grid1;
	protected HtmlGraphicImage image1;
	protected UINamingContainer subview1;
	protected HtmlOutputText text1;
	private CustomerMstr customerMstr;
	protected HtmlForm form1;
	protected HtmlInputText custid1;
	protected HtmlInputText custname1;
	protected HtmlInputText custemail1;
	protected HtmlInputText custdesc1;
	protected HtmlInputText alottedspace1;
	protected HtmlInputText availablespace1;
	protected HtmlCommandButton id1;
	protected HtmlMessages id2messages;
	protected HtmlPanelGrid getGrid1() {
		if (grid1 == null) {
			grid1 = (HtmlPanelGrid) findComponentInRoot("grid1");
		}
		return grid1;
	}

	protected HtmlGraphicImage getImage1() {
		if (image1 == null) {
			image1 = (HtmlGraphicImage) findComponentInRoot("image1");
		}
		return image1;
	}

	protected UINamingContainer getSubview1() {
		if (subview1 == null) {
			subview1 = (UINamingContainer) findComponentInRoot("subview1");
		}
		return subview1;
	}

	protected HtmlOutputText getText1() {
		if (text1 == null) {
			text1 = (HtmlOutputText) findComponentInRoot("text1");
		}
		return text1;
	}

	@JPA(targetEntityManager = ssms.entities.controller.CustomerMstrManager.class, targetAction = JPA.ACTION_TYPE.CREATE)
	public CustomerMstr getCustomerMstr() {
		if (customerMstr == null) {
			CustomerMstrManager customerMstrManager = (CustomerMstrManager) getManagedBean("CustomerMstrManager");
			customerMstr = customerMstrManager.getNewCustomerMstr();
		}
		return customerMstr;
	}

	/**
	 *  @action id=customerMstr
	 */
	public String createCustomerMstrAction() {
		logger.info("Adding new customer...");
		CustomerMstrManager customerMstrManager = (CustomerMstrManager) getManagedBean("CustomerMstrManager");
		try {
			String custid = customerMstr.getCustid();
			CustomerMstr temp = customerMstrManager.findCustomerMstrByCustid(custid);
			if (temp != null){
				throw new Exception("Customer ID " + custid + " already existed.");
			}
			if(customerMstr.getAlottedspace() != customerMstr.getAvailablespace()){
				throw new Exception("Alotted Space and Available Space do not match.");
			}
			customerMstrManager.createCustomerMstr(customerMstr);
			logger.info("Customer added " + custid);
			FacesContext.getCurrentInstance().getExternalContext().redirect("addCustomerResult.html?custid=" + custid);
		} catch (Exception e) {
			logger.error("Cannot add customer caused by ", e);
			getFacesContext().addMessage("custid", new 
					FacesMessage(e.getMessage()));
			return "error";
		}
		
		return "add";
	}

	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}

	protected HtmlInputText getCustid1() {
		if (custid1 == null) {
			custid1 = (HtmlInputText) findComponentInRoot("custid1");
		}
		return custid1;
	}

	protected HtmlInputText getCustname1() {
		if (custname1 == null) {
			custname1 = (HtmlInputText) findComponentInRoot("custname1");
		}
		return custname1;
	}

	protected HtmlInputText getCustemail1() {
		if (custemail1 == null) {
			custemail1 = (HtmlInputText) findComponentInRoot("custemail1");
		}
		return custemail1;
	}

	protected HtmlInputText getCustdesc1() {
		if (custdesc1 == null) {
			custdesc1 = (HtmlInputText) findComponentInRoot("custdesc1");
		}
		return custdesc1;
	}

	protected HtmlInputText getAlottedspace1() {
		if (alottedspace1 == null) {
			alottedspace1 = (HtmlInputText) findComponentInRoot("alottedspace1");
		}
		return alottedspace1;
	}

	protected HtmlInputText getAvailablespace1() {
		if (availablespace1 == null) {
			availablespace1 = (HtmlInputText) findComponentInRoot("availablespace1");
		}
		return availablespace1;
	}

	protected HtmlCommandButton getId1() {
		if (id1 == null) {
			id1 = (HtmlCommandButton) findComponentInRoot("id1");
		}
		return id1;
	}

	protected HtmlMessages getId2messages() {
		if (id2messages == null) {
			id2messages = (HtmlMessages) findComponentInRoot("id2messages");
		}
		return id2messages;
	}

}