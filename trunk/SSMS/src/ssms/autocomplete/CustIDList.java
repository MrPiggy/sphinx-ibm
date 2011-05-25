package ssms.autocomplete;

import java.util.ArrayList;
import java.util.List;

import pagecode.PageCodeBase;
import ssms.entities.CustomerMstr;
import ssms.entities.GoodsSpace;
import ssms.entities.controller.CustomerMstrManager;
import ssms.entities.controller.GoodsSpaceManager;
 
public class CustIDList extends PageCodeBase{
    private List<String> IDs;
    private List<String> shipmentIDs;
    private List<CustomerMstr> customers;
    private List<GoodsSpace> goodsSpaces;
    public CustIDList() {
    }
 
    public List<String> getIDs() {
    	IDs = new ArrayList<String>();
    	try {
			CustomerMstrManager customerManager = 
			(CustomerMstrManager)getManagedBean("CustomerMstrManager");
			customers = customerManager.getCustomer();
			if (customers == null) {
				throw new Exception("Unable to get customer list.");
			}
		
			for( CustomerMstr c:customers){
				IDs.add(c.getCustid());
			}
		} catch (Exception e) {
			return null;
		}
        return IDs;
    }
    
    public int getSpace(String id) {
    	int space;
    	try {
			CustomerMstrManager customerManager = 
			(CustomerMstrManager)getManagedBean("CustomerMstrManager");
			CustomerMstr customer = customerManager.findCustomerMstrByCustid(id);
			if (customer == null) {
				throw new Exception("Unable to get customer list.");
			}
		
			space = customer.getAvailablespace();
		} catch (Exception e) {
			return 0;
		}
		
		return space;
    }
    
    public String getName(String id) {
    	String name = "";
    	try {
			CustomerMstrManager customerManager = 
			(CustomerMstrManager)getManagedBean("CustomerMstrManager");
			CustomerMstr customer = customerManager.findCustomerMstrByCustid(id);
			if (customer == null) {
				throw new Exception("Unable to get customer list.");
			}
		
			name = customer.getCustname();
		} catch (Exception e) {
			return null;
		}
        return name;
    }
    
    public List<String> getShipmentIDs(String id){
    	shipmentIDs = new ArrayList<String>();
    	try {
    		GoodsSpaceManager goodsSpaceManager = (GoodsSpaceManager) getManagedBean("GoodsSpaceManager");
			goodsSpaces = goodsSpaceManager.getGoodsSpace(id);
			if (goodsSpaces == null) {
				throw new Exception("Unable to get shipment list.");
			}
		
			for( GoodsSpace g:goodsSpaces){
				shipmentIDs.add(g.getShipmentid());
			}
		} catch (Exception e) {
			return null;
		}
        return shipmentIDs;
    }
}
