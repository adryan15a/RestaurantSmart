package com.restaurant.dao;

import java.util.List;

import com.restaurant.entity.Produse;

public interface ProduseDAO {

	public List<Produse> getProduse();

	public List<Produse> searchProdus(String theSearchName);

	public Produse getProdus(int theId);

}
