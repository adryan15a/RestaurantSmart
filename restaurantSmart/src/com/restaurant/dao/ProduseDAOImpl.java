package com.restaurant.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restaurant.entity.Produse;

@Repository
public class ProduseDAOImpl implements ProduseDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Produse> getProduse() {
		
		Session currentSession = sessionFactory.getCurrentSession();
				
		//create a query ... sort by last name
		Query<Produse> theQuery= currentSession.createQuery("from Produse",Produse.class);
				
		//execute query and get result list
		List<Produse>produse = theQuery.getResultList();
				
		//return result
		return produse;
	}

	@Override
	public List<Produse> searchProdus(String theSearchName) {
		
		// get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query<Produse> theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Produse where lower(numeProdus) like :theName or lower(descriereProdus) like :theName", Produse.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Customer", Produse.class);            
        }
        
        // execute query and get result list
        List<Produse> listaProduse = theQuery.getResultList();
                
        // return the results        
        return listaProduse;
	}

}
