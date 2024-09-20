package com.ufape.preco.basica;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity @Setter @Getter
public class PrecoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valor;
    private Date dataInicio;
    private Date dataFim;
    private Long produtoId;


}
