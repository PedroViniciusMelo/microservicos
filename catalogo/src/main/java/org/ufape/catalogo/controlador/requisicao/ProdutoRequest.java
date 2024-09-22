package org.ufape.catalogo.controlador.requisicao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.ufape.catalogo.basica.Categoria;
import org.ufape.catalogo.basica.Produto;
import org.ufape.catalogo.config.SpringApplicationContext;

@Getter @Setter
public class ProdutoRequest {
	@NotBlank(message ="O nome da categoria é obrigatório")
	private String nome;
	private String descricao;
	private String imagem;

	@NotNull(message ="A categoria é obrigatória")
	private Long categoria;

	public Produto converterParaClasseBasica(Categoria categoria) {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		Produto produto = modelMapper.map(this, Produto.class);
		produto.setCategoria(categoria);
        return produto;
	}
	
	
}
