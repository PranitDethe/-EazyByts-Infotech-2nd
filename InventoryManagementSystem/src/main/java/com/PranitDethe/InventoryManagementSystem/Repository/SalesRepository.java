package com.PranitDethe.InventoryManagementSystem.Repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.PranitDethe.InventoryManagementSystem.Model.SalesReport;

public interface SalesRepository extends JpaRepository<SalesReport, Long> {
    List<SalesReport> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
