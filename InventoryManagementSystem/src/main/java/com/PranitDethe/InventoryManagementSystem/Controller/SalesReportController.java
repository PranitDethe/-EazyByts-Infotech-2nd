package com.PranitDethe.InventoryManagementSystem.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.PranitDethe.InventoryManagementSystem.Model.Product;
import com.PranitDethe.InventoryManagementSystem.Model.SalesReport;
import com.PranitDethe.InventoryManagementSystem.Service.ProductService;
import com.PranitDethe.InventoryManagementSystem.Service.ReportService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reports/sales")
public class SalesReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/period")
    public List<SalesReport> getSalesReportByPeriod(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return reportService.getSalesReportByPeriod(startDate, endDate);
    }

    @GetMapping("/monthly")
    public List<SalesReport> getMonthlySalesReport() {
        return reportService.getMonthlySalesReport();
    }
}
