package ssms.entities.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;

import ssms.entities.CustomerMstr;
import ssms.entities.GoodsSpace;
import com.ibm.jpa.web.NamedQueryTarget;
import java.util.List;
import javax.persistence.Query;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = ssms.entities.GoodsSpace.class)
public class GoodsSpaceManager {

	@Resource
	private UserTransaction utx;
	@PersistenceUnit
	private EntityManagerFactory emf;
	public GoodsSpaceManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createGoodsSpace(GoodsSpace goodsSpace, CustomerMstr customer) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(goodsSpace);
			customer = em.merge(customer);
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
	public String deleteGoodsSpace(GoodsSpace goodsSpace) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			goodsSpace = em.merge(goodsSpace);
			em.remove(goodsSpace);
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
	public String updateGoodsSpace(GoodsSpace goodsSpace, CustomerMstr customer) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			goodsSpace = em.merge(goodsSpace);
			customer = em.merge(customer);
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
	public GoodsSpace findGoodsSpaceByShipmentid(String shipmentid) {
		GoodsSpace goodsSpace = null;
		EntityManager em = getEntityManager();
		try {
			goodsSpace = (GoodsSpace) em.find(GoodsSpace.class, shipmentid);
		} finally {
			em.close();
		}
		return goodsSpace;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public GoodsSpace getNewGoodsSpace() {
	
		GoodsSpace goodsSpace = new GoodsSpace();
	
		return goodsSpace;
	}

	@NamedQueryTarget("getGoodsSpaces")
	public List<GoodsSpace> getGoodsSpace(String custid) {
		EntityManager em = getEntityManager();
		List<GoodsSpace> results = null;
		try {
			Query query = em.createNamedQuery("getGoodsSpaces");
			query.setParameter("custid", custid);
			results = (List<GoodsSpace>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

}