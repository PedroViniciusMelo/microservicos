package org.ufape.estoque.basica;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class EstoqueProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long quantidade;

    private long produtoId;

    @ManyToOne
    private Armazem armazem;

}
