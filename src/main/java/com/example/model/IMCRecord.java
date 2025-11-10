package com.example.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class IMCRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double weight; // kg
    private double imc;
    private String category;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public IMCRecord() {
    }

    public IMCRecord(double weight, double imc, String category, LocalDateTime date, User user) {
        this.weight = weight;
        this.imc = imc;
        this.category = category;
        this.date = date;
        this.user = user;
    }

    // Getters and setters
    // ...
}
