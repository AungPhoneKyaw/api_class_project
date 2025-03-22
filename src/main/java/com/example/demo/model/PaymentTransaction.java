package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "payment_transactions")
public class PaymentTransaction {

    @Id
    private String id;
    private int userId;
    private int songId;
    private double amount;
    private String currency;
    private String paymentMethod;
    private String transactionId;
    private String status;
    private int queuePosition;
    private LocalDateTime timestamp;

    public PaymentTransaction(int userId, int songId, double amount, String currency, String paymentMethod, String transactionId, String status, int queuePosition) {
        this.userId = userId;
        this.songId = songId;
        this.amount = amount;
        this.currency = currency;
        this.paymentMethod = paymentMethod;
        this.transactionId = transactionId;
        this.status = status;
        this.queuePosition = queuePosition;
        this.timestamp = LocalDateTime.now();
    }

    // Getters
    public String getId() { return id; }
    public int getUserId() { return userId; }
    public int getSongId() { return songId; }
    public double getAmount() { return amount; }
    public String getCurrency() { return currency; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getTransactionId() { return transactionId; }
    public String getStatus() { return status; }
    public int getQueuePosition() { return queuePosition; }
    public LocalDateTime getTimestamp() { return timestamp; }
}