package com.restaurant.dao;

import java.util.List;

import com.restaurant.entity.Comenzi;

public interface ComenziDAO {

	Comenzi createComanda();

	void save(Comenzi newComanda);

	List<Comenzi> getComenzi();

	Comenzi getComanda(int theId);

}
