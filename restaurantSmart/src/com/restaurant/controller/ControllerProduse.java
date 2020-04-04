package com.restaurant.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.restaurant.entity.Comenzi;
import com.restaurant.entity.Produse;
import com.restaurant.service.ServiceComenzi;
import com.restaurant.service.ServiceProduse;

@Controller
@RequestMapping("/produse")
public class ControllerProduse {
	
	public static Double total = 0.0;
	
	public static int nrPortiiTotal = 0;

	public static int nrComenzi = 0;
	
	public static List<Produse> cos = new ArrayList<Produse>();
	
	public static List<Produse> produsele = new ArrayList<Produse>();
	
	public static List<Produse> searchProdusele = new ArrayList<Produse>();
	
	public static List<Comenzi> listaComenzi = new ArrayList<Comenzi>();
	
	@Autowired
	private ServiceProduse serviceProduse;
	
	@Autowired
	private ServiceComenzi serviceComenzi;
	
	@GetMapping("/list")
	public String listProduse(Model theModel) {
		
		//Get the products from the service
		produsele = serviceProduse.getProduse();
		
		//Add the customers to the model
		theModel.addAttribute("listaProduse",produsele);
		
		theModel.addAttribute("nrPortiiTotal", nrPortiiTotal);
		
		return"list-produse";
	}
	
	@PostMapping("/search")
    public String searchProduse(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {

        // search customers from the service
		searchProdusele = serviceProduse.searchProdus(theSearchName);
		
		theModel.addAttribute("nrPortiiTotal", nrPortiiTotal);
                
        // add the customers to the model
        theModel.addAttribute("listaProduse", searchProdusele);

        return "list-produse";        
    }
	
	@GetMapping("/adaugaProdusInCos")
	public String adaugaProdusInCos(@RequestParam("IdProdus") int theId,
									Model theModel) {
		
		//grab the product by id call
		Produse theProdus = serviceProduse.getProdus(theId);
		
		//get price and add to total
		total += theProdus.getPretUnitar();
		
		//remove stock from db (-1)
		int newStock = theProdus.getNivelExistent() - 1;
		theProdus.setNivelExistent(newStock);
		
		//increment number of total portions
		nrPortiiTotal += 1;
		
		//add product in list
		cos.add(theProdus);
		
		//add number of portions on model
		theModel.addAttribute("nrPortiiTotal", nrPortiiTotal);
		
		//load listaProduse to model
		theModel.addAttribute("listaProduse",produsele);
		
		theModel.addAttribute("produse", cos);
		
		// send over to our form		
		return "list-produse";
	}
	
	@GetMapping("/cos")
	public String showCos(Model theModel) {
		
		theModel.addAttribute("produse", cos);
		
		theModel.addAttribute("totalCos", total);
		
		theModel.addAttribute("nrPortiiTotal", nrPortiiTotal);
				
		return "list-cos";
	}
	
	@GetMapping("/adaugaPortie")
	public String adaugaPortie(@RequestParam("IdProdus") int theId,
									Model theModel) {
		
		//grab the product by id call
		Produse theProdus = serviceProduse.getProdus(theId);
		
		//get price and add to total
		ControllerProduse.total += theProdus.getPretUnitar();
		
		//remove stock from db (-1)
		int newStock = theProdus.getNivelExistent() - 1;
		theProdus.setNivelExistent(newStock);
		
		//increment number of total portions
		ControllerProduse.nrPortiiTotal += 1;
		
		//add product in list
		ControllerProduse.cos.add(theProdus);
		
		theModel.addAttribute("produse", ControllerProduse.cos);
		
		theModel.addAttribute("totalCos", ControllerProduse.total);
		
		theModel.addAttribute("nrPortiiTotal", ControllerProduse.nrPortiiTotal);
		
		theModel.addAttribute("listaProduse",ControllerProduse.produsele);
		
		// send over to our form		
		return "list-cos";
	}
	
	@GetMapping("/stergePortie")
	public String stergePortie(@RequestParam("IdProdus") int theId,
									Model theModel) {
		//get the product from the database
		Produse theProdus = serviceProduse.getProdus(theId);
		
		//remove product from local List then updating on the model
		for(Produse prod : ControllerProduse.cos) {
			if(theId == prod.getIdProdus()) {
				System.out.println("removing: " + theProdus);
				ControllerProduse.cos.remove(prod);
				break;
			}
		}
		
		//get price and sub from total
		ControllerProduse.total -= theProdus.getPretUnitar();
		
		//decrement number of total portions
		ControllerProduse.nrPortiiTotal -= 1;
		
		//add stock to db (+1)
		int newStock = theProdus.getNivelExistent() + 1;
		theProdus.setNivelExistent(newStock);
		
		theModel.addAttribute("totalCos", ControllerProduse.total);
		
		theModel.addAttribute("nrPortiiTotal", ControllerProduse.nrPortiiTotal);
		
		theModel.addAttribute("produse", ControllerProduse.cos);
		
		theModel.addAttribute("listaProduse",ControllerProduse.produsele);
		
		// send over to our form		
		return "list-cos";
	}
	
	@GetMapping("/trimiteComanda")
	public String trimiteComanda(Model theModel) {
		
		//create new Command
		Comenzi newComanda = serviceComenzi.createComanda();
		
		//parse to a string only the produs id and save it in db(field "continut_comanda")
		String continutcomanda = "";
		
		for(Produse prod : ControllerProduse.cos) {
			continutcomanda += "" + prod.getIdProdus() + ";";
			}
		
		newComanda.setContinutComanda(continutcomanda);
		
		//new Date for field dataCreare and save it in db
		newComanda.setDataCreare(new Date());
		
		//get pretTotal comanda from class and save it to database don`t` forget to also reset & update on model!
		newComanda.setPretTotalComanda(ControllerProduse.total);
		ControllerProduse.total = 0.0;
		
		//get numarProduse comanda from class and save it to database don`t` forget to also reset & update on model!
		newComanda.setNumarProduse(ControllerProduse.nrPortiiTotal);
		ControllerProduse.nrPortiiTotal = 0;
		
		//save newComand on database
		serviceComenzi.save(newComanda);
		
		//save produs objects
		//clear cos and update on model

		ControllerProduse.cos.clear();
		
		theModel.addAttribute("produse", ControllerProduse.cos);
		
		theModel.addAttribute("listaProduse",ControllerProduse.produsele);
		
		theModel.addAttribute("nrPortiiTotal", ControllerProduse.nrPortiiTotal);
		
		return"list-produse";
	}
	
	@GetMapping("/afiseazaComenzi")
	public String afiseazaComenzi(Model theModel) {
		
		
		//get list comenzi from database
		listaComenzi = serviceComenzi.getComenzi();
		
		nrComenzi = listaComenzi.size();
		
		theModel.addAttribute("nrComenzi", nrComenzi);
		
		theModel.addAttribute("comenzi",listaComenzi);
		
		
		
		return"list-comenzi";
	}
	
	@GetMapping("/livrat")
	public String livrat(@RequestParam("IdComanda") int theId,
									Model theModel) {
		
		//get the order(command) by id
		Comenzi comandaLivrata = serviceComenzi.getComanda(theId);
		
		//insert in data base field deliverd date(data_livrare)
		comandaLivrata.setDataLivrare(new Date());
		
		
		
		serviceComenzi.save(comandaLivrata);
		
		theModel.addAttribute("nrComenzi", nrComenzi);
		
		theModel.addAttribute("comenzi",listaComenzi);
	
		return"list-comenzi";
	}
	
	@GetMapping("/incasat")
	public String incasat(@RequestParam("IdComanda") int theId,
									Model theModel) {
		
		//get the order(command) by id
		Comenzi comandaLivrata = serviceComenzi.getComanda(theId);
		
		//insert in data base field deliverd date(data_livrare)
		comandaLivrata.setDataIncasare(new Date());
		
		comandaLivrata.setIncasat(comandaLivrata.getPretTotalComanda());
		
		serviceComenzi.save(comandaLivrata);
		
		//get list comenzi from database
		listaComenzi = serviceComenzi.getComenzi();
		
		theModel.addAttribute("nrComenzi", nrComenzi);
		
		theModel.addAttribute("comenzi",listaComenzi);
	
		return"list-comenzi";
	}
	
	
}
