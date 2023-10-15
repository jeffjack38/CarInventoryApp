package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Car;

public class CarHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CarCatalog");
	
	public void InsertCar(Car own) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(own);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Car> showAllCars(){
		EntityManager em = emfactory.createEntityManager();
		List<Car> allCars = em.createQuery("SELECT i FROM Car i").getResultList();
		return allCars;
		}
	
	public void deleteCar(Car toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car> typedQuery = em.createQuery("select car from Car car where car.make = :selectedMake and car.model = :selectedModel", Car.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedMake", toDelete.getMake());
		typedQuery.setParameter("selectedModel", toDelete.getModel());

		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		Car result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Car searchForCarById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Car found = em.find(Car.class, idToEdit);
		em.close();
		return found;
	}

	public void updateCar(Car toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		}

	public List<Car> searchForCarByMake(String CarName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car> typedQuery = em.createQuery("select car from Car car where car.make = :selectedMake", Car.class);
		typedQuery.setParameter("selectedMake", CarName);
		List<Car> foundCars = typedQuery.getResultList();
		em.close();
		return foundCars;
	}

	public List<Car> searchForCarByModel(String model) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car> typedQuery = em.createQuery("select car from Car car where car.model = :selectedModel", Car.class);
		typedQuery.setParameter("selectedModel", model);
		List<Car> foundModel = typedQuery.getResultList();
		em.close();
		return foundModel;
		}
	
	public void cleanUp() {
		emfactory.close();
	}
}