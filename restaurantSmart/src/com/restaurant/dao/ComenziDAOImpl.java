package com.restaurant.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restaurant.entity.Comenzi;

@Repository
public class ComenziDAOImpl implements ComenziDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Comenzi createComanda() {
		return new Comenzi();
	}

	@Override
	public void save(Comenzi newComanda) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		//save/ update the customer ... finaly LOL
		currentSession.saveOrUpdate(newComanda);
		
	}

	@Override
	public List<Comenzi> getComenzi() {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query ... sort by last name
		Query<Comenzi> theQuery= currentSession.createQuery("from Comenzi where incasat = null",Comenzi.class);
						
		//execute query and get result list
		List<Comenzi>comenzi = theQuery.getResultList();
		
		
		return comenzi;
	}

	@Override
	public Comenzi getComanda(int theId) {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//get Comanda by id
		Comenzi theComanda = currentSession.get(Comenzi.class, theId);
		
		return theComanda;
	}

}
