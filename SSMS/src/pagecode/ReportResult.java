/**
 * 
 */
package pagecode;

import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.component.UINamingContainer;
import javax.faces.component.html.HtmlOutputText;
import java.util.List;
import ssms.entities.controller.CustomerMstrManager;
import com.ibm.jpa.web.JPA;
import ssms.entities.CustomerMstr;
import com.ibm.jpa.web.JPAFilter;
import javax.faces.component.html.HtmlMessages;
import ssms.entities.GoodsSpace;
import ssms.entities.controller.GoodsSpaceManager;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.UIColumn;
import javax.faces.component.html.HtmlOutcomeTargetButton;

/**
 * @author db2admin
 *
 */
public class ReportResult extends PageCodeBase {

	protected HtmlPanelGrid grid1;
	protected HtmlGraphicImage image1;
	protected UINamingContainer subview1;
	protected HtmlOutputText text1;
	private CustomerMstr customerMstr;
	protected HtmlOutputText custid1;
	protected HtmlOutputText custname1;
	protected HtmlOutputText alottedspace1;
	protected HtmlOutputText availablespace1;
	protected HtmlMessages id1messages;
	private List<GoodsSpace> goodsSpaceList;
	protected HtmlDataTable goodsSpaceList1;
	protected UIColumn shipmentid1column;
	protected HtmlOutputText shipmentid1text;
	protected HtmlOutputText number1text;
	protected HtmlOutputText spaceRequired1text;
	protected HtmlOutputText status1text;
	protected HtmlOutputText shipmentid1;
	protected UIColumn number1column;
	protected HtmlOutputText number1;
	protected UIColumn spaceRequired1column;
	protected HtmlOutputText spaceRequired1;
	protected UIColumn status1column;
	protected HtmlOutputText status1;
	protected HtmlMessages id2messages;
	protected HtmlOutcomeTargetButton button1;

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

	protected HtmlOutputText getCustid1() {
		if (custid1 == null) {
			custid1 = (HtmlOutputText) findComponentInRoot("custid1");
		}
		return custid1;
	}

	protected HtmlOutputText getCustname1() {
		if (custname1 == null) {
			custname1 = (HtmlOutputText) findComponentInRoot("custname1");
		}
		return custname1;
	}

	protected HtmlOutputText getAlottedspace1() {
		if (alottedspace1 == null) {
			alottedspace1 = (HtmlOutputText) findComponentInRoot("alottedspace1");
		}
		return alottedspace1;
	}

	protected HtmlOutputText getAvailablespace1() {
		if (availablespace1 == null) {
			availablespace1 = (HtmlOutputText) findComponentInRoot("availablespace1");
		}
		return availablespace1;
	}

	protected HtmlMessages getId1messages() {
		if (id1messages == null) {
			id1messages = (HtmlMessages) findComponentInRoot("id1messages");
		}
		return id1messages;
	}

	protected HtmlDataTable getGoodsSpaceList1() {
		if (goodsSpaceList1 == null) {
			goodsSpaceList1 = (HtmlDataTable) findComponentInRoot("goodsSpaceList1");
		}
		return goodsSpaceList1;
	}

	protected UIColumn getShipmentid1column() {
		if (shipmentid1column == null) {
			shipmentid1column = (UIColumn) findComponentInRoot("shipmentid1column");
		}
		return shipmentid1column;
	}

	protected HtmlOutputText getShipmentid1text() {
		if (shipmentid1text == null) {
			shipmentid1text = (HtmlOutputText) findComponentInRoot("shipmentid1text");
		}
		return shipmentid1text;
	}

	protected HtmlOutputText getNumber1text() {
		if (number1text == null) {
			number1text = (HtmlOutputText) findComponentInRoot("number1text");
		}
		return number1text;
	}

	protected HtmlOutputText getSpaceRequired1text() {
		if (spaceRequired1text == null) {
			spaceRequired1text = (HtmlOutputText) findComponentInRoot("spaceRequired1text");
		}
		return spaceRequired1text;
	}

	protected HtmlOutputText getStatus1text() {
		if (status1text == null) {
			status1text = (HtmlOutputText) findComponentInRoot("status1text");
		}
		return status1text;
	}

	protected HtmlOutputText getShipmentid1() {
		if (shipmentid1 == null) {
			shipmentid1 = (HtmlOutputText) findComponentInRoot("shipmentid1");
		}
		return shipmentid1;
	}

	protected UIColumn getNumber1column() {
		if (number1column == null) {
			number1column = (UIColumn) findComponentInRoot("number1column");
		}
		return number1column;
	}

	protected HtmlOutputText getNumber1() {
		if (number1 == null) {
			number1 = (HtmlOutputText) findComponentInRoot("number1");
		}
		return number1;
	}

	protected UIColumn getSpaceRequired1column() {
		if (spaceRequired1column == null) {
			spaceRequired1column = (UIColumn) findComponentInRoot("spaceRequired1column");
		}
		return spaceRequired1column;
	}

	protected HtmlOutputText getSpaceRequired1() {
		if (spaceRequired1 == null) {
			spaceRequired1 = (HtmlOutputText) findComponentInRoot("spaceRequired1");
		}
		return spaceRequired1;
	}

	protected UIColumn getStatus1column() {
		if (status1column == null) {
			status1column = (UIColumn) findComponentInRoot("status1column");
		}
		return status1column;
	}

	protected HtmlOutputText getStatus1() {
		if (status1 == null) {
			status1 = (HtmlOutputText) findComponentInRoot("status1");
		}
		return status1;
	}

	protected HtmlMessages getId2messages() {
		if (id2messages == null) {
			id2messages = (HtmlMessages) findComponentInRoot("id2messages");
		}
		return id2messages;
	}

	protected HtmlOutcomeTargetButton getButton1() {
		if (button1 == null) {
			button1 = (HtmlOutcomeTargetButton) findComponentInRoot("button1");
		}
		return button1;
	}

	@JPA(targetEntityManager = ssms.entities.controller.CustomerMstrManager.class, targetNamedQuery = "getCustomerMstr", targetAction = JPA.ACTION_TYPE.FIND)
	@JPAFilter(name = "custid", value = "#{sessionScope.custid}")
	public CustomerMstr getCustomerMstr() {
		if (customerMstr == null) {
			CustomerMstrManager customerMstrManager = (CustomerMstrManager) getManagedBean("CustomerMstrManager");
			String custid = (String) resolveParam("customerMstr_custid",
					"#{sessionScope.custid}", "java.lang.String");
			List<CustomerMstr> list = customerMstrManager
					.getCustomerMstr(custid);
			if (!list.isEmpty()) {
				customerMstr = list.get(0);
			}
		}
		return customerMstr;
	}

	@JPA(targetEntityManager = ssms.entities.controller.GoodsSpaceManager.class, targetNamedQuery = "getGoodsSpace")
	@JPAFilter(name = "custid", value = "#{sessionScope.custid}")
	public List<GoodsSpace> getGoodsSpaceList() {
		if (goodsSpaceList == null) {
			GoodsSpaceManager goodsSpaceManager = (GoodsSpaceManager) getManagedBean("GoodsSpaceManager");
			String custid = (String) resolveParam("goodsSpaceList_custid",
					"#{sessionScope.custid}", "java.lang.String");
			goodsSpaceList = goodsSpaceManager.getGoodsSpace(custid);
		}
		return goodsSpaceList;
	}

}