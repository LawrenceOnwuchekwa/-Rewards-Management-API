package com.masterhills.RewardsManagement.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "customers")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;

    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "total_cashback")
    private double total_cashback;

    @Column(name = "current_balance")
    private double current_balance;


    public Customer() {
    }

    public Customer(int customer_id, UUID uuid, String email, String password, double total_cashback, double current_balance) {
        this.customer_id = customer_id;
        this.uuid = uuid;
        this.email = email;
        this.password = password;
        this.total_cashback = total_cashback;
        this.current_balance = current_balance;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
