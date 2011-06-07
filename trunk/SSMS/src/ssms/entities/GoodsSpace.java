package ssms.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GOODS_SPACE database table.
 * 
 */
@Entity
@Table(name="GOODS_SPACE")
@NamedQuery(name = "getGoodsSpaces", query = "SELECT g FROM GoodsSpace g WHERE g.custid=:custid")
public class GoodsSpace implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String shipmentid;

	private String custid;

	private int number;

	@Column(name="SPACE_REQUIRED")
	private int spaceRequired;

	private String status;

    public GoodsSpace() {
    }

	public String getShipmentid() {
		return this.shipmentid;
	}

	public void setShipmentid(String shipmentid) {
		this.shipmentid = shipmentid;
	}

	public String getCustid() {
		return this.custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getSpaceRequired() {
		return this.spaceRequired;
	}

	public void setSpaceRequired(int spaceRequired) {
		this.spaceRequired = spaceRequired;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}