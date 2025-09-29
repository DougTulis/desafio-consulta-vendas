package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;

public class SaleSummaryDTO {

	private String sellerName;
	private Double sum;
	
	public SaleSummaryDTO() {
	}
	
	public SaleSummaryDTO(String sellerName, Double sum) {
		this.sellerName = sellerName;
		this.sum = sum;
	}
	
	public String getSellerName() {
		return sellerName;
	}

	public Double getSum() {
		return sum;
	}

}
