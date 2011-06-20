/**
 * 
 */
package pagecode;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.component.UINamingContainer;
import javax.faces.component.html.HtmlOutputText;

import ssms.email.EmailNotification;
import ssms.entities.CustomerMstr;
import ssms.entities.GoodsSpace;
import ssms.entities.controller.CustomerMstrManager;
import ssms.entities.controller.GoodsSpaceManager;
import com.ibm.jpa.web.JPA;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlMessages;
import com.ibm.jpa.web.JPAFilter;

/**
 * @author db2admin
 *
 */
public class Export extends PageCodeBase {

	protected HtmlPanelGrid grid1;
	protected HtmlGraphicImage image1;
	protected UINamingContainer subview1;
	protected HtmlOutputText text1;
	private GoodsSpace goodsSpace;
	protected HtmlForm form1;
	protected HtmlInputText custid1;
	protected HtmlInputText number1;
	protected HtmlInputText spaceRequired1;
	protected HtmlCommandButton id1;
	protected HtmlMessages id2messages;
	protected HtmlInputText custName1;
	protected HtmlInputText shipmentid1;
	protected HtmlInputText avaiSpace1;
	private CustomerMstr customerMstr;
	protected HtmlInputText avaiSpace2;
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

	@JPA(targetEntityManager = ssms.entities.controller.GoodsSpaceManager.class, targetAction = JPA.ACTION_TYPE.CREATE)
	public GoodsSpace getGoodsSpace() {
		if (goodsSpace == null) {
			GoodsSpaceManager goodsSpaceManager = (GoodsSpaceManager) getManagedBean("GoodsSpaceManager");
			goodsSpace = goodsSpaceManager.getNewGoodsSpace();
		}
		return goodsSpace;
	}

	/**
	 *  @action id=goodsSpace
	 */
	public String exportGoodsSpaceAction() {
		String result = "";
		try {
			result = doValidateAction();
		} catch (Exception e) {
			logException(e);
		}
		return result;
	}
	
	protected String doValidateAction() {
		try {
			String custid = goodsSpace.getCustid();
			CustomerMstrManager customerManager = 
			(CustomerMstrManager)getManagedBean("CustomerMstrManager");
			customerMstr = customerManager.findCustomerMstrByCustid(custid);
			if (customerMstr == null) {
				throw new Exception("Customer ID " + custid + " was not found.");
			}
			
			GoodsSpaceManager goodsSpaceManager = (GoodsSpaceManager) getManagedBean("GoodsSpaceManager");
			GoodsSpace temp = goodsSpaceManager.findGoodsSpaceByShipmentid(goodsSpace.getShipmentid());
			if( temp == null){
				throw new Exception("Shipment ID " + goodsSpace.getShipmentid() + " was not found.");
			}
			else if(!temp.getCustid().equalsIgnoreCase(custid)){
				throw new Exception("Customer ID " + custid + " and Shipment ID does not match.");
			}
			else if (temp.getStatus().trim().equalsIgnoreCase("Out")){
				throw new Exception("Shipment already exported.");
			}
				
			temp.setStatus("Out");
			
			int change = customerMstr.getAvailablespace() + temp.getSpaceRequired();
			customerMstr.setAvailablespace(change);
			//customerManager.updateCustomerMstr(customer);
			
			goodsSpaceManager.updateGoodsSpace(temp, customerMstr);
			
			EmailNotification emailModule = new EmailNotification();
			emailModule.setCustomerMstr(customerMstr);
			emailModule.setGoodsSpace(goodsSpace);
			emailModule.sendEmail();
		} catch (Exception e) {
			getFacesContext().addMessage("custid", new 
					FacesMessage(e.getMessage()));
			return "error";
		}
		
		return "export";
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

	protected HtmlInputText getNumber1() {
		if (number1 == null) {
			number1 = (HtmlInputText) findComponentInRoot("number1");
		}
		return number1;
	}

	protected HtmlInputText getSpaceRequired1() {
		if (spaceRequired1 == null) {
			spaceRequired1 = (HtmlInputText) findComponentInRoot("spaceRequired1");
		}
		return spaceRequired1;
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

	protected HtmlInputText getCustName1() {
		if (custName1 == null) {
			custName1 = (HtmlInputText) findComponentInRoot("custName1");
		}
		return custName1;
	}

	protected HtmlInputText getShipmentid1() {
		if (shipmentid1 == null) {
			shipmentid1 = (HtmlInputText) findComponentInRoot("shipmentid1");
		}
		return shipmentid1;
	}

	protected HtmlInputText getAvaiSpace1() {
		if (avaiSpace1 == null) {
			avaiSpace1 = (HtmlInputText) findComponentInRoot("avaiSpace1");
		}
		return avaiSpace1;
	}

	@JPA(targetEntityManager = ssms.entities.controller.CustomerMstrManager.class, targetAction = JPA.ACTION_TYPE.FIND)
	@JPAFilter(name = "custid", value = "#{param.custid}")
	public CustomerMstr getCustomerMstr() {
		if (customerMstr == null) {
			CustomerMstrManager customerMstrManager = (CustomerMstrManager) getManagedBean("CustomerMstrManager");
			String custid = (String) resolveParam("customerMstr_custid",
					"#{param.custid}", "java.lang.String");
			customerMstr = customerMstrManager.findCustomerMstrByCustid(custid);
		}
		return customerMstr;
	}

	protected HtmlInputText getAvaiSpace2() {
		if (avaiSpace2 == null) {
			avaiSpace2 = (HtmlInputText) findComponentInRoot("avaiSpace2");
		}
		return avaiSpace2;
	}

}