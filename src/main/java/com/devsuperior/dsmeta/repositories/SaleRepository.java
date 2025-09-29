package com.devsuperior.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import com.devsuperior.dsmeta.entities.Sale;
//ong id, Double amount, String date, String sellerName
public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query(value = "SELECT new com.devsuperior.dsmeta.dto.SaleReportDTO(obj.id,obj.amount,obj.date,obj.seller.name) "
			+ "FROM Sale obj "
			+ "WHERE obj.date BETWEEN :minDate AND :maxDate "
			+ "AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name,'%'))",
			countQuery = "SELECT COUNT(obj) FROM Sale obj JOIN obj.seller")
	Page<SaleReportDTO> searchReport(LocalDate minDate, LocalDate maxDate, String name, Pageable pageable);

	@Query(value = "SELECT new com.devsuperior.dsmeta.dto.SaleSummaryDTO(obj.seller.name,SUM(obj.amount)) "
			+ "FROM Sale obj "
			+ "WHERE obj.date BETWEEN :minDate AND :maxDate "
			+ "GROUP BY obj.seller.name", 
			countQuery = "SELECT COUNT(obj) FROM Sale obj JOIN obj.seller")
	Page<SaleSummaryDTO> searchSummary(LocalDate minDate, LocalDate maxDate, Pageable pageable);


}
