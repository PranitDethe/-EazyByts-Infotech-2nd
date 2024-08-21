package com.PranitDethe.InventoryManagementSystem.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProductPerformanceReport {
    @Id
    private Long id;
    private String productName;
    private int quantitySold;
    private double totalRevenue;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantitySold() {
		return quantitySold;
	}
	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}
	public double getTotalRevenue() {
		return totalRevenue;
	}
	public void setTotalRevenue(double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

    // Getters and Setters
    
    
}