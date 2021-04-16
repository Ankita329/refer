package com.project.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GenericDao {

	public Object save(Object obj) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("oracleTest");
			em = emf.createEntityManager();
			
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
	        Object objt = em.merge(obj); 
			
			tx.commit();
			return objt;
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
	
	public Object fetch(Class clazz, Object pk) {
			EntityManagerFactory emf = null;
			EntityManager em = null;			
			try {
				emf = Persistence.createEntityManagerFactory("oracleTest");
			    em = emf.createEntityManager();	
			    Object obj = em.find(clazz, pk);				
			    return obj;
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
	
	public void save2(Object obj) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("oracleTest");
			em = emf.createEntityManager();
			
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
	        em.persist(obj); 
			
			tx.commit();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		finally {
			em.close();
			emf.close();	
		}		
	}
}
