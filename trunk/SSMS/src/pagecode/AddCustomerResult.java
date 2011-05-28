/**
 * 
 */
package pagecode;

import java.util.Map;

import javax.faces.context.FacesContext;

import ssms.entities.CustomerMstr;
import ssms.entities.controller.CustomerMstrManager;
import com.ibm.jpa.web.JPA;
import com.ibm.jpa.web.JPAFilter;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlMessages;

/**
 * @author ManMan
 *
 */
public class AddCustomerResult extends PageCodeBase {

	private CustomerMstr customerMstr;
	protected HtmlOutputText custid1;
	protected HtmlOutputText custname1;
	protected HtmlOutputText custemail1;
	protected HtmlOutputText custdesc1;
	protected HtmlOutputText alottedspace1;
	protected HtmlOutputText availablespace1;
	protected HtmlMessages id1messages;

	@JPA(targetEntityManager = ssms.entities.controller.CustomerMstrManager.class, targetAction = JPA.ACTION_TYPE.FIND)
	@JPAFilter(name = "custid", value = "#{param.custid}")
	public CustomerMstr getCustomerMstr() {
		if (customerMstr == null) {
			CustomerMstrManager customerMstrManager = (CustomerMstrManager) getManagedBean("CustomerMstrManager");
			Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String custid = params.get("custid");
			customerMstr = customerMstrManager.findCustomerMstrByCustid(custid);
		}
		return customerMstr;
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

	protected HtmlOutputText getCustemail1() {
		if (custemail1 == null) {
			custemail1 = (HtmlOutputText) findComponentInRoot("custemail1");
		}
		return custemail1;
	}

	protected HtmlOutputText getCustdesc1() {
		if (custdesc1 == null) {
			custdesc1 = (HtmlOutputText) findComponentInRoot("custdesc1");
		}
		return custdesc1;
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

}