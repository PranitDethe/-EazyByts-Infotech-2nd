package com.PranitDethe.InventoryManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PranitDethe.InventoryManagementSystem.Model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}