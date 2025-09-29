package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}
	
	public Page<SaleReportDTO> searchReport(LocalDate minDate, LocalDate maxDate, String name, Pageable pageable) {
		if(maxDate == null) {
			LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
			maxDate = today;
		}
	 
		 if (minDate == null) {
			LocalDate result = maxDate.minusYears(1L);
			minDate = result;
		}		
		 return repository.searchReport(minDate,maxDate,name,pageable);
	}

	public Page<SaleSummaryDTO> searchSummary(LocalDate minDate, LocalDate maxDate, Pageable pageable) {
		if(maxDate == null) {
			LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
			maxDate = today;
		}
	 
		 if (minDate == null) {
			LocalDate result = maxDate.minusYears(1L);
			minDate = result;
		}	
		return repository.searchSummary(minDate,maxDate,pageable);
	}
	
}
