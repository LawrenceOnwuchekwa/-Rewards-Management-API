package com.masterhills.RewardsManagement.model;

import com.masterhills.RewardsManagement.utility.UUIDGenerator;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "customers")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_id;

    // Store UUID as a String with VARCHAR(36)
    @Column(name = "uuid", unique = true, nullable = false, length = 36)
    private String uuid;

    @Column(name = "total_cashback")
    private double total_cashback;

    @Column(name = "current_balance")
    private double current_balance;

    @OneToOne
    private Credentials credential;

    @OneToMany
    private List<Transaction> transactionList;


    public Customer() {
        this.uuid = UUIDGenerator.generateUUID().toString();
    }

    public Customer(Long customer_id, String uuid, double total_cashback, double current_balance, Credentials credential, List<Transaction> transactionList) {
        this.customer_id = customer_id;
        this.uuid = uuid;
        this.total_cashback = total_cashback;
        this.current_balance = current_balance;
        this.credential = credential;
        this.transactionList = transactionList;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


    public double getTotal_cashback() {
        return total_cashback;
    }

    public void setTotal_cashback(double total_cashback) {
        this.total_cashback = total_cashback;
    }

    public double getCurrent_balance() {
        return current_balance;
    }

    public void setCurrent_balance(double current_balance) {
        this.current_balance = current_balance;
    }

    public Credentials getCredential() {
        return credential;
    }

    public void setCredential(Credentials credential) {
        this.credential = credential;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}

