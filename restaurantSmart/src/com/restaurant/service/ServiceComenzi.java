package com.restaurant.service;

import java.util.List;

import com.restaurant.entity.Comenzi;

public interface ServiceComenzi {

	Comenzi createComanda();

	void save(Comenzi newComanda);

	List<Comenzi> getComenzi();

	Comenzi getComanda(int theId);

}
