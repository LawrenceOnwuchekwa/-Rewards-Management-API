package com.masterhills.RewardsManagement.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transaction_id;

    @Column(name = "uuid")
    private UUID transaction_uuid;

    @Column(name = "transaction_date")
    private Date transaction_date;

    @Column(name = "amount")
    private double amount;

    @Column(name = "description")
    private String transaction_description;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Transaction() {
    }

    public Transaction(int transaction_id, UUID transaction_uuid, Date transaction_date, double amount, String transaction_description, Customer customer) {
        this.transaction_id = transaction_id;
        this.transaction_uuid = transaction_uuid;
        this.transaction_date = transaction_date;
        this.amount = amount;
        this.transaction_description = transaction_description;
        this.customer = customer;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public UUID getTransaction_uuid() {
        return transaction_uuid;
    }

    public void setTransaction_uuid(UUID transaction_uuid) {
        this.transaction_uuid = transaction_uuid;
    }

    public Date getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(Date transaction_date) {
        this.transaction_date = transaction_date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransaction_description() {
        return transaction_description;
    }

    public void setTransaction_description(String transaction_description) {
        this.transaction_description = transaction_description;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
