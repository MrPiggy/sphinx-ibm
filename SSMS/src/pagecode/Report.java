/**
 * 
 */
package pagecode;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.component.UINamingContainer;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlMessages;

import ssms.entities.CustomerMstr;
import ssms.entities.controller.CustomerMstrManager;
import javax.faces.event.AjaxBehaviorEvent;

/**
 * @author db2admin
 *
 */
public class Report extends PageCodeBase {

	protected HtmlPanelGrid grid1;
	protected HtmlGraphicImage image1;
	protected UINamingContainer subview1;
	protected HtmlOutputText text1;
	protected HtmlForm form1;
	protected HtmlInputText custid1;
	protected HtmlCommandButton sessionScope1;
	protected HtmlMessages sessionScope2messages;
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

	protected HtmlCommandButton getSessionScope1() {
		if (sessionScope1 == null) {
			sessionScope1 = (HtmlCommandButton) findComponentInRoot("sessionScope1");
		}
		return sessionScope1;
	}

	protected HtmlMessages getSessionScope2messages() {
		if (sessionScope2messages == null) {
			sessionScope2messages = (HtmlMessages) findComponentInRoot("sessionScope2messages");
		}
		return sessionScope2messages;
	}
	
	public String doReportAction() {
		try {
			String custid = (String) getSessionScope().get("custid");
			System.out.println("Report for CustID: " + custid);
			CustomerMstrManager customerManager = 
			(CustomerMstrManager)getManagedBean("CustomerMstrManager");
			CustomerMstr customer = customerManager.findCustomerMstrByCustid(custid);
			if (customer == null) {
				throw new Exception("Customer ID " + custid + " was not found.");
			}
			return "report";
		} catch (Exception e) {
			getFacesContext().addMessage("custid", new 
					FacesMessage(e.getMessage()));
					return null;
		}
	}

	public void handleAjax(AjaxBehaviorEvent event)
			throws javax.faces.event.AbortProcessingException {
		// Type Java code for the listener here
	
		// void handleAjax(AjaxBehaviorEvent event) throws AbortProcessingException
	}
}