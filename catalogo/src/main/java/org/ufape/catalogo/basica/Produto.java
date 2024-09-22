package org.ufape.catalogo.basica;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String descricao;
	private String imagem;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

}
