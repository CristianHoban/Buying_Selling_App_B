package com.example.restservice.model;

import jakarta.persistence.*;

@Entity
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "email_s")
    private String email_s;
    @Column(name = "email_b")
    private String email_b;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Trade(long id, String email_s, String email_b, Product product) {
        this.id = id;
        this.email_s = email_s;
        this.email_b = email_b;
        this.product = product;
    }

    public Trade(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail_s() {
        return email_s;
    }

    public void setEmail_s(String email_s) {
        this.email_s = email_s;
    }

    public String getEmail_b() {
        return email_b;
    }

    public void setEmail_b(String email_b) {
        this.email_b = email_b;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
