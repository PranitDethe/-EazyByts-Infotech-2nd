package com.PranitDethe.InventoryManagementSystem.Controller;

import com.PranitDethe.InventoryManagementSystem.Model.ProductPerformanceReport;
import com.PranitDethe.InventoryManagementSystem.Service.ReportService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reports/product-performance")
public class ProductPerformanceReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    public List<ProductPerformanceReport> getProductPerformanceReport() {
        return reportService.getProductPerformanceReport();
    }
}