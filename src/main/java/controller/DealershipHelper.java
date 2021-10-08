package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Dealership;

/**
 * @author Jamison Bice - jdbice
 * CIS175 - Fall 2021
 * Oct 6, 2021
 */

public class DealershipHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week6_JPAJoinsProject");

	public void insertDealership(Dealership d) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	}

	public List<Dealership> showAllDealerships() {
		EntityManager em = emfactory.createEntityManager();
		List<Dealership> allDealerships = em.createQuery("SELECT d  FROM Dealership d").getResultList();
		return allDealerships;
	}
	public Dealership findDealership(String nameToLookUp) { 
		EntityManager em = emfactory.createEntityManager(); em.getTransaction().begin(); 
		TypedQuery<Dealership> typedQuery = em.createQuery("select de  from Dealership de where de.dealerName = :selectedName", Dealership.class);
		typedQuery.setParameter("selectedName", nameToLookUp); typedQuery.setMaxResults(1); 
		Dealership foundDealership; 
		try { 
		foundDealership = typedQuery.getSingleResult(); 
		} catch (NoResultException ex) { 
		foundDealership = new Dealership(nameToLookUp); 
		} 
		em.close(); 
		return foundDealership; 
		}

}
