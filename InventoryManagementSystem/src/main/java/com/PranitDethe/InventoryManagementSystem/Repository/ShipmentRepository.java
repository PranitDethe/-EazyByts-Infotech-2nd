package com.PranitDethe.InventoryManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PranitDethe.InventoryManagementSystem.Model.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}
