package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Owner;

public class OwnerHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CarCatalog");
	
	public void InsertItem(Owner own) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(own);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Owner> showAllOwners(){
		EntityManager em = emfactory.createEntityManager();
		// was getting "Type safety: The expression of type List needs unchecked conversion to conform to List<ListItem>" so I added "@SuppressWarnings("unchecked")"
		@SuppressWarnings("unchecked")
		List<Owner> allItems = em.createQuery("SELECT i FROM Owner i").getResultList();
		return allItems;
		}
	
	public void deleteItem(Owner toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Owner> typedQuery = em.createQuery("select own from Owner own where own.name = :selectedName and own.contactNumber = :selectedContactNumber", Owner.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedContactNumber", toDelete.getContactNumber());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		Owner result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Owner searchForOwnerById(int idToEdit) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	Owner found = em.find(Owner.class, idToEdit);
	em.close();
	return found;
	}

	public void updateOwner(Owner toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		}

	public List<Owner> searchForOwnerByName(String ownerName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Owner> typedQuery = em.createQuery("select own from Owner own where own.name = :selectedName", Owner.class);
		typedQuery.setParameter("selectedName", ownerName);
		List<Owner> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Owner> searchForOwnerByContactNumber(String contactNumber) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Owner> typedQuery = em.createQuery("select own from Owner own where own.contactNumber = :selectedContactNumber", Owner.class);
		typedQuery.setParameter("selectedItem", contactNumber);
		List<Owner> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
		}
	
	public void cleanUp() {
		emfactory.close();
	}
}