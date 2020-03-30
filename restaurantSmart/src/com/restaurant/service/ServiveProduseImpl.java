package com.restaurant.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.dao.ProduseDAO;
import com.restaurant.entity.Produse;

@Service
public class ServiveProduseImpl implements ServiceProduse {
	
	@Autowired
	private ProduseDAO produseDAO;

	@Override
	@Transactional
	public List<Produse> getProduse() {
		
		return produseDAO.getProduse();
	}

	@Override
	@Transactional
	public List<Produse> searchProdus(String theSearchName) {
		
		return produseDAO.searchProdus(theSearchName);
	}

}
