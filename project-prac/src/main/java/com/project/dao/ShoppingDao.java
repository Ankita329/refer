package com.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.project.entity.CartItem;
import com.project.entity.OrderItem;
import com.project.entity.Product;
import com.project.entity.User;

public class ShoppingDao extends GenericDao{

	/*
	 * Display products by category
	 */
	public List<Product> displayProductOfCategory(String name) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("oracleTest");
			 em = emf.createEntityManager();
			 String jpql = "SELECT p FROM Product p INNER JOIN fetch p.category c WHERE c.name = : cat";
			 Query q = em.createQuery(jpql);
		     q.setParameter("cat", name);
		     List<Product> list = q.getResultList();
		     return list;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			em.close();
			emf.close();
		}		
		
	}
	/*
	 * check order status by user
	 */
	
	public List<OrderItem> CheckOrderStatus(int userId) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("oracleTest");
			 em = emf.createEntityManager();
			 String jpql = "SELECT oi from OrderItem oi INNER JOIN oi.order o  where o.user : id ";
			 Query q = em.createQuery(jpql);
		     q.setParameter("id", userId);
		     List<OrderItem> list = q.getResultList();
		     return list;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			em.close();
			emf.close();
		}		
		
	}
	
	public List<CartItem> displayCartItems(int userId) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("oracleTest");
			 em = emf.createEntityManager();
			 String jpql = "SELECT ci FROM CartItem ci INNER JOIN ci.cart c  WHERE c.user : id ";
			 Query q = em.createQuery(jpql);
		     q.setParameter("id", userId);
		     List<CartItem> list = q.getResultList();
		     return list;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			em.close();
			emf.close();
		}		
		
		
	}
	/*
	 * Filter products based on price
	 */
	
	public List<Product> displayProductByPrice(double amount) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("oracleTest");
			 em = emf.createEntityManager();
			 String jpql = "select p FROM Product p where p.price <= :amt";
			 Query q = em.createQuery(jpql);
		     q.setParameter("amt", amount);
		     List<Product> list = q.getResultList();
		     return list;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			em.close();
			emf.close();
		}	
	}
	
		/*
		 * for compare products selected by user
		 */
		public List<Product> fetchProduct(int productId) {
			EntityManagerFactory emf = null;
			EntityManager em = null;
			try {
				emf = Persistence.createEntityManagerFactory("oracleTest");
				 em = emf.createEntityManager();
				 String jpql = "select p FROM Product p where p.id <= :id";
				 Query q = em.createQuery(jpql);
			     q.setParameter("id", productId);
			     List<Product> list = q.getResultList();
			     return list;
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
			finally {
				em.close();
				emf.close();
			}	
	}
		
		public List<User> fetchUser(int uid) {
			EntityManagerFactory emf = null;
			EntityManager em = null;
			try {
				emf = Persistence.createEntityManagerFactory("oracleTest");
				 em = emf.createEntityManager();
				 String jpql = "select u FROM User u where u.id = :id";
				 Query q = em.createQuery(jpql);
			     q.setParameter("id",uid);
			     List<User> list = q.getResultList();
			     return list;
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
			finally {
				em.close();
				emf.close();
			}	
		}
		
	
}
