package com.PranitDethe.InventoryManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PranitDethe.InventoryManagementSystem.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByBarcode(String barcode);
    List<Product> findByQuantityLessThan(int threshold);
}