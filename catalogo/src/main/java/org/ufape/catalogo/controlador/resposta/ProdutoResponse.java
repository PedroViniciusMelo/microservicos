package org.ufape.catalogo.controlador.resposta;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.ufape.catalogo.basica.Categoria;
import org.ufape.catalogo.basica.Produto;
import org.ufape.catalogo.config.SpringApplicationContext;

import java.util.List;

@Getter @Setter
public class ProdutoResponse {
	private long id;
	private String nome;
	private String descricao;
	private String imagem;

	private List<Categoria> categoriaList;

	public ProdutoResponse(Produto produto) {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		modelMapper.map(produto, this);
	}

}
