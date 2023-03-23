package org.example.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Fraud
{
    @Id
    @SequenceGenerator(name ="fraud_id_sequence",sequenceName = "fraud_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fraud_id_sequence")
    private Integer id;
    private Integer customerID;
    private Boolean isFraudster;
    private LocalDateTime createdAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Boolean getFraudster() {
        return isFraudster;
    }

    public void setFraudster(Boolean fraudster) {
        isFraudster = fraudster;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Fraud() {
    }

    public Fraud(Integer id, Integer customerID, Boolean isFraudster, LocalDateTime createdAt) {
        this.id = id;
        this.customerID = customerID;
        this.isFraudster = isFraudster;
        this.createdAt = createdAt;
    }
}
