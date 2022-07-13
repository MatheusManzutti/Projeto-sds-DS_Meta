package com.dsmeta.dsmeta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsmeta.dsmeta.entities.Sale;
import com.dsmeta.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@GetMapping //ANNOTATION PARA RESPONDER VIA WEB, USANDO HTTP.
	public List<Sale> findSales() {
		return service.findSales();
	}

}
