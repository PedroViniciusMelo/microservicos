package com.ufape.price.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Double value;
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;
}
