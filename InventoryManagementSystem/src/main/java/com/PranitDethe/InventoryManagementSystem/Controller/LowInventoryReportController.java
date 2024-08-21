package com.PranitDethe.InventoryManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.PranitDethe.InventoryManagementSystem.Model.Product;
import com.PranitDethe.InventoryManagementSystem.Service.ProductService;
@RestController
@RequestMapping("/reports/low-inventory")
public class LowInventoryReportController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getLowInventoryReport(@RequestParam int threshold) {
        return productService.getLowInventoryProducts(threshold);
    }
}