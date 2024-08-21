package com.PranitDethe.InventoryManagementSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.PranitDethe.InventoryManagementSystem.Model.Shipment;
import com.PranitDethe.InventoryManagementSystem.Repository.ShipmentRepository;

@Service
public class ShipmentService {
    @Autowired
    private ShipmentRepository shipmentRepository;

    public Shipment createShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    public Shipment getShipmentById(Long id) {
        return shipmentRepository.findById(id).orElse(null);
    }

    public Shipment updateShipment(Long id, Shipment shipment) {
        if (shipmentRepository.existsById(id)) {
            shipment.setId(id);
            return shipmentRepository.save(shipment);
        }
        return null;
    }
}