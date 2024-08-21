package com.PranitDethe.InventoryManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PranitDethe.InventoryManagementSystem.Model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerId(Long customerId);
}