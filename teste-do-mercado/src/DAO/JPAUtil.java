package DAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory emf;
	
	private JPAUtil() { 
	}
	
	public static EntityManagerFactory getEMF() { 
		if (emf == null) { 
			emf = Persistence.createEntityManagerFactory("MERCADORIA");
		}
		return emf;
	}
}