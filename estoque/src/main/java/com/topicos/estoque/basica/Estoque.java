package com.topicos.estoque.basica;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantidade;

    private long produtoId;

    @ManyToOne
    @JoinColumn(name = "armazem_id")
    private Armazem armazem;
}
