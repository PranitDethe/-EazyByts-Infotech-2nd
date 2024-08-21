package com.PranitDethe.InventoryManagementSystem.Service;

import com.PranitDethe.InventoryManagementSystem.Model.Payment;
import com.PranitDethe.InventoryManagementSystem.Repository.PaymentRepository;
import com.stripe.Stripe;
import com.stripe.model.Charge;
import com.stripe.param.ChargeCreateParams;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Value("${stripe.api.key}")
    private String stripeApiKey;

    @PostConstruct
    private void init() {
        Stripe.apiKey = stripeApiKey;
    }

    public Payment processPayment(Payment payment) {
        // Example of using Stripe to process a payment
        ChargeCreateParams params = ChargeCreateParams.builder()
            .setAmount((long) (payment.getAmount() * 100)) // Amount in cents
            .setCurrency("usd")
            .setSource("tok_visa") // Replace with actual source
            .setDescription("Charge for order " + payment.getOrderId())
            .build();

        try {
            Charge charge = Charge.create(params);
            payment.setStatus(charge.getStatus());
            return paymentRepository.save(payment);
        } catch (Exception e) {
            throw new RuntimeException("Payment processing failed: " + e.getMessage());
        }
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }
}
