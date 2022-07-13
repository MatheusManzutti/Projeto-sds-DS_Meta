package com.dsmeta.dsmeta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsmeta.dsmeta.entities.Sale;

//COMPONENTE RESPONSÁVEL POR ACESSAR O BD

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
