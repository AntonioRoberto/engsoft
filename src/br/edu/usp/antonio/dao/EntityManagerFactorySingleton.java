package br.edu.usp.antonio.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	private static final EntityManagerFactory emf;  
    
    static {  
        try {  
            // Create the SessionFactory from hibernate.cfg.xml  
            emf = Persistence.createEntityManagerFactory("sample-persistence-unit");  
        } catch (Throwable ex) {  
            // Make sure you log the exception, as it might be swallowed  
            System.err.println("Initial SessionFactory creation failed." + ex);  
            throw new ExceptionInInitializerError(ex);  
        }  
    }  
      
    public static EntityManagerFactory getEntityManagerFactory() {  
        return emf;  
    }  
}  

