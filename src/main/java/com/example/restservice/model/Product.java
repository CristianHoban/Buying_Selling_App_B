package com.example.restservice.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "type")
    private String type;
    @Column(name = "product_condition")
    private String condition;
    @Column(name = "promoted")
    private int promoted;
    @Column(name = "price")
    private double price;
    @Column(name = "description")
    private String description;

    /**
     * anotatia @OneToMany ajuta la corectitudinea modului in care foreign key lucreaza. orphanRemoval setet pe true, asigura
     * ca in momentul in care se sterg parintii, copiii corespunzatori vor fi si ei eliminati din baza de date
     */
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Photo> photos = new ArrayList<>();

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Trade trade;
    public Product(long id, User user, String type, String condition, int promoted, double price, String description) {
        this.id = id;
        this.user = user;
        this.type = type;
        this.condition = condition;
        this.promoted = promoted;
        this.price = price;
        this.description = description;
    }

    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getPromoted() {
        return promoted;
    }

    public void setPromoted(int promoted) {
        this.promoted = promoted;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
