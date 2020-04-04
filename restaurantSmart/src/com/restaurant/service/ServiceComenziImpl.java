package com.restaurant.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.dao.ComenziDAO;
import com.restaurant.entity.Comenzi;

@Service
public class ServiceComenziImpl implements ServiceComenzi {

	@Autowired
	private ComenziDAO comenziDAO;

	@Override
	@Transactional
	public Comenzi createComanda() {
		
		return comenziDAO.createComanda();
	}

	@Override
	@Transactional
	public void save(Comenzi newComanda) {
		
		comenziDAO.save(newComanda);
	}

	@Override
	@Transactional
	public List<Comenzi> getComenzi() {
		return comenziDAO.getComenzi();
	}

	@Override
	@Transactional
	public Comenzi getComanda(int theId) {
		return comenziDAO.getComanda(theId);
	}
}
