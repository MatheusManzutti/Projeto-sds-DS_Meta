package com.dsmeta.dsmeta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsmeta.dsmeta.entities.Sale;
import com.dsmeta.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	public List<Sale> findSales() {
		return repository.findAll(); //BUSCA UMA LISTA DE TODOS OS DADOS NO BD.
	}
}
