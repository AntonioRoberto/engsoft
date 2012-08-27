package br.edu.usp.antonio.dao;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class JPAListener implements ServletContextListener {  
	public void contextInitialized(ServletContextEvent servletContextEvent) {  
		EntityManagerFactory entityManagerFactory = EntityManagerFactorySingleton.getEntityManagerFactory();  
	}

	public void contextDestroyed(ServletContextEvent servletContextEvent) {  
		EntityManagerFactorySingleton.getEntityManagerFactory().close();  
	}  
    
} 