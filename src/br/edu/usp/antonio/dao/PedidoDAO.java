package br.edu.usp.antonio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.ejb.EntityManagerImpl;

import br.com.caelum.vraptor.ioc.Component;
import br.edu.usp.antonio.modelo.Item;
import br.edu.usp.antonio.modelo.Pedido;


@Component
public class PedidoDAO {
	
	public static void salvarPedido(Pedido pedido){
		EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();	
		
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(pedido);
		em.getTransaction().commit();
	}	
	public static void removePedido(Long id){
		EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();	
		
		EntityManager em = emf.createEntityManager();
		
		Pedido pedido = em.find(Pedido.class, id);

		em.getTransaction().begin();
		em.remove(pedido);
		em.getTransaction().commit();
	}	

	public Pedido carregaPedido(Long id) {
		EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();	
		
		EntityManager em = emf.createEntityManager();
		
		return em.find(Pedido.class, id);		
	}
	
	public static List<Pedido> listaTudo() {
		EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();	
		
		EntityManager entityManager = emf.createEntityManager();
		Session session;  
		if (entityManager.getDelegate() instanceof EntityManagerImpl) {  
		    EntityManagerImpl entityManagerImpl = (EntityManagerImpl) entityManager.getDelegate();  
		    session = (Session) entityManagerImpl.getSession();  
		} else {  
		    session = (Session) entityManager.getDelegate();  
		}
		return session.createCriteria(Pedido.class).list();
	}

}