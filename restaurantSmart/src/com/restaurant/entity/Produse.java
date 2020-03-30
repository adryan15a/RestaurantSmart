package com.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produse")
public class Produse {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produs")
	private int idProdus;
	
	//@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	//@JoinColumn(name="id_categorie")
	@Column(name = "id_categorie")
	private int idCategorie;
	
	@Column(name = "nume_produs")
	private String numeProdus;
	
	@Column(name = "descriere_produs")
	private String descriereProdus;
	
	@Column(name = "pret_unitar")
	private Double pretUnitar;
	
	@Column(name = "nivel_existent")
	private int nivelExistent;
	
	@Column(name = "nivel_alerta")
	private int nivelAlerta;

	public Produse() {
	}

	public Produse(String numeProdus, String descriereProdus, Double pretUnitar, int nivelExistent, int nivelAlerta) {
		this.numeProdus = numeProdus;
		this.descriereProdus = descriereProdus;
		this.pretUnitar = pretUnitar;
		this.nivelExistent = nivelExistent;
		this.nivelAlerta = nivelAlerta;
	}

	public int getIdProdus() {
		return idProdus;
	}

	public void setIdProdus(int idProdus) {
		this.idProdus = idProdus;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNumeProdus() {
		return numeProdus;
	}

	public void setNumeProdus(String numeProdus) {
		this.numeProdus = numeProdus;
	}

	public String getDescriereProdus() {
		return descriereProdus;
	}

	public void setDescriereProdus(String descriereProdus) {
		this.descriereProdus = descriereProdus;
	}

	public Double getPretUnitar() {
		return pretUnitar;
	}

	public void setPretUnitar(Double pretUnitar) {
		this.pretUnitar = pretUnitar;
	}

	public int getNivelExistent() {
		return nivelExistent;
	}

	public void setNivelExistent(int nivelExistent) {
		this.nivelExistent = nivelExistent;
	}

	public int getNivelAlerta() {
		return nivelAlerta;
	}

	public void setNivelAlerta(int nivelAlerta) {
		this.nivelAlerta = nivelAlerta;
	}

	@Override
	public String toString() {
		return "Produse [idProdus=" + idProdus + ", idCategorie=" + idCategorie + ", numeProdus=" + numeProdus
				+ ", descriereProdus=" + descriereProdus + ", pretUnitar=" + pretUnitar + ", nivelExistent="
				+ nivelExistent + ", nivelAlerta=" + nivelAlerta + "]";
	}
	
	
	
	

}
