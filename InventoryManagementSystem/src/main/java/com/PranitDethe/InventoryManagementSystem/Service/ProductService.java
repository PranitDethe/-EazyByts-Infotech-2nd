package com.PranitDethe.InventoryManagementSystem.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.PranitDethe.InventoryManagementSystem.Model.Product;
import com.PranitDethe.InventoryManagementSystem.Repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product getProductByBarcode(String barcode) {
        return productRepository.findByBarcode(barcode);
    }

    public List<Product> getLowInventoryProducts(int threshold) {
        return productRepository.findByQuantityLessThan(threshold);
    }

	public Product updateProduct(Long id, Product product) {
		// TODO Auto-generated method stub
		return null;
	}
}