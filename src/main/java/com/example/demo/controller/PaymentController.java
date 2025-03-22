package com.example.demo.controller;

import com.example.demo.model.PaymentTransaction;
import com.example.demo.repository.PaymentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentRepository paymentRepository;

    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @PostMapping("/process")
    public ResponseEntity<Map<String, Object>> processPayment(@RequestBody Map<String, Object> paymentRequest) {
        int userId = (int) paymentRequest.get("user_id");
        int songId = (int) paymentRequest.get("song_id");
        double amount = Double.parseDouble(paymentRequest.get("amount").toString());
        String currency = (String) paymentRequest.get("currency");
        String paymentMethod = (String) paymentRequest.get("payment_method");

        // Generate a unique transaction ID
        String transactionId = "txn_" + UUID.randomUUID();

        // Simulate queue position (e.g., count transactions)
        int queuePosition = (int) paymentRepository.count() + 1;

        // Create and save transaction
        PaymentTransaction transaction = new PaymentTransaction(userId, songId, amount, currency, paymentMethod, transactionId, "completed", queuePosition);
        paymentRepository.save(transaction);

        // Prepare response
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Payment successful");
        response.put("transaction_id", transactionId);
        response.put("status", "completed");
        response.put("queue_position", queuePosition);

        return ResponseEntity.ok(response);
    }
}