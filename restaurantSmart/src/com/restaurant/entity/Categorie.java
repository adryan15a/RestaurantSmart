package com.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorie")
public class Categorie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categorie_produs")
	private int idCategorieProdus;
	
	@Column(name = "nume_categorie_produs")
	String numeCategorieProdus;

	public Categorie() {
	}

	public Categorie(String numeCategorieProdus) {
		this.numeCategorieProdus = numeCategorieProdus;
	}

	public int getIdCategorieProdus() {
		return idCategorieProdus;
	}

	public void setIdCategorieProdus(int idCategorieProdus) {
		this.idCategorieProdus = idCategorieProdus;
	}

	public String getNumeCategorieProdus() {
		return numeCategorieProdus;
	}

	public void setNumeCategorieProdus(String numeCategorieProdus) {
		this.numeCategorieProdus = numeCategorieProdus;
	}

	@Override
	public String toString() {
		return "Categorie [idCategorieProdus=" + idCategorieProdus + ", numeCategorieProdus=" + numeCategorieProdus
				+ "]";
	}
	

}
