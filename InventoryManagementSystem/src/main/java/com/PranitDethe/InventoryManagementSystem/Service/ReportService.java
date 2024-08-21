package com.PranitDethe.InventoryManagementSystem.Service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PranitDethe.InventoryManagementSystem.Model.ProductPerformanceReport;
import com.PranitDethe.InventoryManagementSystem.Model.SalesReport;
import com.PranitDethe.InventoryManagementSystem.Repository.SalesRepository;

@Service
public class ReportService {

    @Autowired
    private SalesRepository salesRepository;

    public List<SalesReport> getSalesReportByPeriod(LocalDate startDate, LocalDate endDate) {
        return salesRepository.findByDateBetween(startDate, endDate);
    }

    public List<SalesReport> getMonthlySalesReport() {
        LocalDate now = LocalDate.now();
        LocalDate startDate = now.withDayOfMonth(1);
        LocalDate endDate = now.withDayOfMonth(now.lengthOfMonth());
        return salesRepository.findByDateBetween(startDate, endDate);
    }

	public List<ProductPerformanceReport> getProductPerformanceReport() {
		// TODO Auto-generated method stub
		return null;
	}


}
