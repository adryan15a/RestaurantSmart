package com.restaurant.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comenzi")
public class Comenzi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_comanda")
	private int idComanda;
	
	@Column(name = "data_creare")
	private Date dataCreare;
	
	@Column(name = "data_livrare")
	private Date dataLivrare;
	
	@Column(name = "pret_total_comanda")
	private Double pretTotalComanda;
	
	@Column(name = "numar_produse")
	private int numarProduse;
	
	@Column(name = "incasat")
	private Double incasat;
	
	@Column(name = "data_incasare")
	private Date dataIncasare;
	
	@Column(name = "continut_comanda")
	private String continutComanda;

	public Comenzi() {
	}

	public Comenzi(int idComanda, Date dataCreare, Date dataLivrare, Double pretTotalComanda, int numarProduse,
			Double incasat, Date dataIncasare, String continutComanda) {
		this.idComanda = idComanda;
		this.dataCreare = dataCreare;
		this.dataLivrare = dataLivrare;
		this.pretTotalComanda = pretTotalComanda;
		this.numarProduse = numarProduse;
		this.incasat = incasat;
		this.dataIncasare = dataIncasare;
		this.continutComanda = continutComanda;
	}

	public int getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}

	public Date getDataCreare() {
		return dataCreare;
	}

	public void setDataCreare(Date dataCreare) {
		this.dataCreare = dataCreare;
	}

	public Date getDataLivrare() {
		return dataLivrare;
	}

	public void setDataLivrare(Date dataLivrare) {
		this.dataLivrare = dataLivrare;
	}

	public Double getPretTotalComanda() {
		return pretTotalComanda;
	}

	public void setPretTotalComanda(Double pretTotalComanda) {
		this.pretTotalComanda = pretTotalComanda;
	}

	public int getNumarProduse() {
		return numarProduse;
	}

	public void setNumarProduse(int numarProduse) {
		this.numarProduse = numarProduse;
	}

	public Double getIncasat() {
		return incasat;
	}

	public void setIncasat(Double incasat) {
		this.incasat = incasat;
	}

	public Date getDataIncasare() {
		return dataIncasare;
	}

	public void setDataIncasare(Date dataIncasare) {
		this.dataIncasare = dataIncasare;
	}

	public String getContinutComanda() {
		return continutComanda;
	}

	public void setContinutComanda(String continutComanda) {
		this.continutComanda = continutComanda;
	}

	@Override
	public String toString() {
		return "Comenzi [idComanda=" + idComanda + ", dataCreare=" + dataCreare + ", dataLivrare=" + dataLivrare
				+ ", pretTotalComanda=" + pretTotalComanda + ", numarProduse=" + numarProduse + ", incasat=" + incasat
				+ ", dataIncasare=" + dataIncasare + ", continutComanda=" + continutComanda + "]";
	}

}
