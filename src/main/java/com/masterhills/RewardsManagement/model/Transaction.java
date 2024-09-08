package com.masterhills.RewardsManagement.model;

import com.masterhills.RewardsManagement.utility.UUIDGenerator;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transaction_id;

    @Column(name = "uuid", unique = true, length = 36, nullable = false)
    private String uuid;

    @Column(name = "transaction_date",nullable = false, updatable = false)
    private LocalDateTime transaction_date;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    private Customer customer;

    public Transaction() {
        this.uuid = UUIDGenerator.generateUUID().toString();
        this.transaction_date = LocalDateTime.now();
    }

    public Transaction(Long transaction_id, String transaction_uuid, LocalDateTime transaction_date, double amount, String transaction_description, Customer customer) {
        this.transaction_id = transaction_id;
        this.uuid = uuid;
        this.transaction_date = transaction_date;
        this.amount = amount;
        this.description = description;
        this.customer = customer;
    }

    public Long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public LocalDateTime getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(LocalDateTime transaction_date) {
        this.transaction_date = transaction_date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
