package com.dsmeta.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dsmeta.dsmeta.entities.Sale;
import com.dsmeta.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@GetMapping //ANNOTATION PARA RESPONDER VIA WEB, USANDO HTTP.
	public Page<Sale> findSales(
			//ANNOTATION PARA INFORMAR SE NÃO FOR INFORMADO O NOME DA REQUISIÇÃO (minDate; maxDate), VAI VOLTA VAZIO "" 
								@RequestParam(value = "minDate", defaultValue = "") String minDate, 
								@RequestParam(value = "maxDate", defaultValue = "") String maxDate, 
								Pageable pageable) { //PARÂMETRO QUE VOLTA UMA BUSCA PAGINADA
		return service.findSales(minDate, maxDate, pageable); 
	}

}
