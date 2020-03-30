package com.restaurant.service;

import java.util.List;

import com.restaurant.entity.Produse;

public interface ServiceProduse {

	public List<Produse> getProduse();

	public List<Produse> searchProdus(String theSearchName);

}
