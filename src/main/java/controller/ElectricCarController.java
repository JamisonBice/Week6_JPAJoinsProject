package controller;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ElectricCar;

public class ElectricCarController {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week6_JPAJoinsProject");
	
	public void insertItem(ElectricCar ec) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ec);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<ElectricCar> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<ElectricCar> allItems = em.createQuery("SELECT i from ElectricCar i").getResultList();
		return allItems;
		
	}

	public void deleteItem(ElectricCar toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ElectricCar> typedQuery = em.createQuery("select ec from ElectricCar ec where ec.range = :selectedRange and ec.make = :selectedMake and ec.model = :selectedModel and ec.price = :selectedPrice", ElectricCar.class);
		
		typedQuery.setParameter("selectedRange", toDelete.getRange());
		typedQuery.setParameter("selectedMake", toDelete.getMake());
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		typedQuery.setParameter("selectedPrice", toDelete.getPrice());
		
		typedQuery.setMaxResults(1);
		
		ElectricCar result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public ElectricCar searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		ElectricCar found = em.find(ElectricCar.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(ElectricCar toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<ElectricCar> searchForItemByRange(String carRange) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ElectricCar> typedQuery = em.createQuery("select ec from ElectricCar ec where ec.range = :selectedRange", ElectricCar.class);
		
		typedQuery.setParameter("selectedRange", carRange);
		
		List<ElectricCar> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<ElectricCar> searchForItemByMake(String carMake) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ElectricCar> typedQuery = em.createQuery("select ec from ElectricCar ec where ec.make = :selectedMake", ElectricCar.class);
		
		typedQuery.setParameter("selectedMake", carMake);
		
		List<ElectricCar> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public List<ElectricCar> searchForItemByModel(String carModel) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ElectricCar> typedQuery = em.createQuery("select ec from ElectricCar ec where ec.model = :selectedModel", ElectricCar.class);
		
		typedQuery.setParameter("selectedModel", carModel);
		
		List<ElectricCar> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public List<ElectricCar> searchForItemByPrice(String carPrice) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ElectricCar> typedQuery = em.createQuery("select ec from ElectricCar ec where ec.price = :selectedPrice", ElectricCar.class);
		
		typedQuery.setParameter("selectedPrice", carPrice);
		
		List<ElectricCar> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
	
}