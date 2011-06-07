package ssms.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CUSTOMER_MSTR database table.
 * 
 */
@Entity
@Table(name="CUSTOMER_MSTR")
@NamedQueries({@NamedQuery(name = "getCustomer", query = "SELECT c FROM CustomerMstr c"),@NamedQuery(name = "getCustomerMstr", query = "SELECT c FROM CustomerMstr c WHERE c.custid=:custid")})
public class CustomerMstr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String custid;

	private int alottedspace;

	private int availablespace;

	private String custdesc;

	private String custemail;

	private String custname;

    public CustomerMstr() {
    }

	public String getCustid() {
		return this.custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public int getAlottedspace() {
		return this.alottedspace;
	}

	public void setAlottedspace(int alottedspace) {
		this.alottedspace = alottedspace;
	}

	public int getAvailablespace() {
		return this.availablespace;
	}

	public void setAvailablespace(int availablespace) {
		this.availablespace = availablespace;
	}

	public String getCustdesc() {
		return this.custdesc;
	}

	public void setCustdesc(String custdesc) {
		this.custdesc = custdesc;
	}

	public String getCustemail() {
		return this.custemail;
	}

	public void setCustemail(String custemail) {
		this.custemail = custemail;
	}

	public String getCustname() {
		return this.custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

}