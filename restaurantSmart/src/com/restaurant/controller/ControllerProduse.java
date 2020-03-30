package com.restaurant.controller;

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
	
	@Autowired
	private ServiceProduse serviceProduse;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		//Get the customers from the dao
		List<Produse> produsele = serviceProduse.getProduse();
		
		//Add the customers to the model
		theModel.addAttribute("produse",produsele);
		
		return"list-produse";
	}
	
	@PostMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {

        // search customers from the service
        List<Produse> theProduse = serviceProduse.searchProdus(theSearchName);
                
        // add the customers to the model
        theModel.addAttribute("produse", theProduse);

        return "list-produse";        
    }

}
