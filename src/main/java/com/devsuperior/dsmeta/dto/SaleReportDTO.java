package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.entities.Seller;

public class SaleReportDTO {

	
	private Long id;
	private Double amount;
	private String date;
	
	private String sellerName;

	public SaleReportDTO() {
	
	}
	
	public SaleReportDTO(Long id, Double amount, LocalDate date, String sellerName) {
		this.id = id;
		this.amount = amount;
		this.date = date.toString();
		this.sellerName = sellerName;
	}
	
	public SaleReportDTO(Sale entity) {
		id = entity.getId();
		amount = entity.getAmount();
		date = entity.getDate().toString();
		sellerName = entity.getSeller().getName();
	}

	public Long getId() {
		return id;
	}

	public Double getAmount() {
		return amount;
	}

	public String getDate() {
		return date;
	}

	public String getSellerName() {
		return sellerName;
	}
	
}
