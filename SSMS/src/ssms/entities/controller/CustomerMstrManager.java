package ssms.entities.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import ssms.entities.CustomerMstr;
import java.util.List;
import javax.persistence.Query;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = ssms.entities.CustomerMstr.class)
public class CustomerMstrManager {

	@Resource
	private UserTransaction utx;
	@PersistenceUnit
	private EntityManagerFactory emf;

	public CustomerMstrManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createCustomerMstr(CustomerMstr customerMstr)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(customerMstr);
			utx.commit();
		} catch (Exception ex) {
			try {
				utx.rollback();
			} catch (Exception e) {
				ex.printStackTrace();
				throw e;
			}
			throw ex;
		} finally {
			em.close();
		}
		return "";
	}

	@Action(Action.ACTION_TYPE.DELETE)
	public String deleteCustomerMstr(CustomerMstr customerMstr)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			customerMstr = em.merge(customerMstr);
			em.remove(customerMstr);
			utx.commit();
		} catch (Exception ex) {
			try {
				utx.rollback();
			} catch (Exception e) {
				ex.printStackTrace();
				throw e;
			}
			throw ex;
		} finally {
			em.close();
		}
		return "";
	}

	@Action(Action.ACTION_TYPE.UPDATE)
	public String updateCustomerMstr(CustomerMstr customerMstr)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			customerMstr = em.merge(customerMstr);
			utx.commit();
		} catch (Exception ex) {
			try {
				utx.rollback();
			} catch (Exception e) {
				ex.printStackTrace();
				throw e;
			}
			throw ex;
		} finally {
			em.close();
		}
		return "";
	}

	@Action(Action.ACTION_TYPE.FIND)
	public CustomerMstr findCustomerMstrByCustid(String custid) {
		CustomerMstr customerMstr = null;
		EntityManager em = getEntityManager();
		try {
			customerMstr = (CustomerMstr) em.find(CustomerMstr.class, custid);
		} finally {
			em.close();
		}
		return customerMstr;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public CustomerMstr getNewCustomerMstr() {
	
		CustomerMstr customerMstr = new CustomerMstr();
	
		return customerMstr;
	}

	@NamedQueryTarget("getCustomerMstr")
	public List<CustomerMstr> getCustomerMstr(String custid) {
		EntityManager em = getEntityManager();
		List<CustomerMstr> results = null;
		try {
			Query query = em.createNamedQuery("getCustomerMstr");
			query.setParameter("custid", custid);
			results = (List<CustomerMstr>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getCustomer")
	public List<CustomerMstr> getCustomer() {
		EntityManager em = getEntityManager();
		List<CustomerMstr> results = null;
		try {
			Query query = em.createNamedQuery("getCustomer");
			results = (List<CustomerMstr>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

}