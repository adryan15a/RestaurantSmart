package com.restaurant.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.restaurant.entity.Produse;
import com.restaurant.service.ServiceProduse;

@Controller
@RequestMapping("/produse")
public class ControllerProduse {
	
	public List<Produse> cos = new ArrayList<Produse>();
	
	public List<Produse> produsele = new ArrayList<Produse>();
	
	public List<Produse> searchProdusele = new ArrayList<Produse>();
	
	public Double total = 0.0;
	
	public int nrPortiiTotal = 0;
	
	public int nrPortii = 0; 
	
	@Autowired
	private ServiceProduse serviceProduse;
	
	@GetMapping("/list")
	public String listProduse(Model theModel) {
		
		//Get the customers from the dao
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
		
		//increment number of total portions
		nrPortiiTotal += 1;
		
		//add product in list
		cos.add(theProdus);
		
		//add number of portions on model
		theModel.addAttribute("nrPortiiTotal", nrPortiiTotal);
		
		//load listaProduse to model
		theModel.addAttribute("listaProduse",produsele);
		
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
		total += theProdus.getPretUnitar();
		
		//increment number of total portions
		nrPortiiTotal += 1;
		
		//add product in list
		cos.add(theProdus);
		
		theModel.addAttribute("produse", cos);
		
		theModel.addAttribute("totalCos", total);
		
		theModel.addAttribute("nrPortiiTotal", nrPortiiTotal);
		
		// send over to our form		
		return "list-cos";
	}

}
