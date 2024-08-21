package com.PranitDethe.InventoryManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.PranitDethe.InventoryManagementSystem.Model.ProductPerformanceReport;

public interface ProductPerformanceRepository extends JpaRepository<ProductPerformanceReport, Long> {
}
