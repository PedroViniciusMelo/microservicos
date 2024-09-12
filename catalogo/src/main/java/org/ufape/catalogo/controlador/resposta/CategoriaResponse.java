package org.ufape.catalogo.controlador.resposta;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.ufape.catalogo.basica.Categoria;
import org.ufape.catalogo.config.SpringApplicationContext;

@Getter @Setter
public class CategoriaResponse {
	private long id;
	private String nome;
	private String descricao;
	private String icone;
	private long categoriaPaiId;
	
	public CategoriaResponse(Categoria categoria) {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		modelMapper.map(categoria, this);
	}

}
