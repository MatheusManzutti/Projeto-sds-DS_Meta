package com.dsmeta.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dsmeta.dsmeta.entities.Sale;
import com.dsmeta.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	 //BUSCA UMA LISTA DE TODOS OS DADOS NO BD.
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {

		//LocalDate = CONVERTE AS DATAS QUE ESTÃO EM STRING.
		//LocalDate.parse = CONVERTE A STRING PARA A DATA NO LocalDate.
		
		//PEGA A DATA ATUAL
		LocalDate today = LocalDate.ofInstant(Instant.now(), //PEGA O INSTANTE ATUAL
											  ZoneId.systemDefault() //PEGA O FUSO HORÁRIO DO SISTEMA
											 );
				
		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
		/*minDate.equals("") = TESTA SE O MINDATE É IGUAL A UM TEXTO VAZIO (NÃO INFORMADO).
		  ? today.minusDays(365) = SE FOR VERDADE VOLTA A DATA DE UM ANO ATRÁS, SENÃO VOLTA A DATA DO LOCALDATE.
		  OU SEJA, O minusDays SUBTRAI OS DIAS*/
		
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
		/*maxDate.equals("") = TESTA SE O MAXDATE É IGUAL A UM TEXTO VAZIO (NÃO INFORMADO).
		  ? today = SE FOR VERDADE VOLTA A DATA ATUAL, SENÃO VOLTA A DATA DO LOCALDATE.*/

		
		return repository.findSales(min, max, pageable);
	}
}















