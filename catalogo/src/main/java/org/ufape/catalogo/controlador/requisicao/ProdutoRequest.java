package org.ufape.catalogo.controlador.requisicao;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.ufape.catalogo.basica.Produto;
import org.ufape.catalogo.config.SpringApplicationContext;

@Getter @Setter
public class ProdutoRequest {
	@NotBlank(message ="O nome da categoria é obrigatório")
	private String nome;
	private String descricao;
	private String imagem;

	public Produto converterParaClasseBasica() {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        return modelMapper.map(this, Produto.class);
		
	}
	
	
}
