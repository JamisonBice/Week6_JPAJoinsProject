package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.OrderDetails;

/**
 * @author Jamison Bice - jdbice
 * CIS175 - Fall 2021
 * Oct 6, 2021
 */
public class OrderDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week6_JPAJoinsProject");

	public void insertNewOrderDetails(OrderDetails ec) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ec);
		em.getTransaction().commit();
		em.close();
	}

	public List<OrderDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<OrderDetails> allDetails = em.createQuery("SELECT  d FROM OrderDetails d").getResultList();
		return allDetails;
	}

	public void deleteList(OrderDetails toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<OrderDetails> typedQuery = em.createQuery("select detail from OrderDetails detail where detail.id = :selectedId", OrderDetails.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		OrderDetails result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public OrderDetails searchForOrderDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		OrderDetails found = em.find(OrderDetails.class, tempId);
		em.close();
		return found;
	}
	public void updateList(OrderDetails toEdit) { 
		EntityManager em = emfactory.createEntityManager(); em.getTransaction().begin(); 
		em.merge(toEdit); 
		em.getTransaction().commit(); 
		em.close(); 
		} 
}
