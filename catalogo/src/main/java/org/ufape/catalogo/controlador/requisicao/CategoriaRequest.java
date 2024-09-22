package org.ufape.catalogo.controlador.requisicao;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.ufape.catalogo.basica.Categoria;
import org.ufape.catalogo.config.SpringApplicationContext;

@Getter @Setter
public class CategoriaRequest {
	@NotBlank(message ="O nome da categoria é obrigatório")
	private String nome;
	private String descricao;
	private String icone;

	private Long pai;

	public Categoria converterParaClasseBasica(Categoria pai) {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		Categoria categoria = modelMapper.map(this, Categoria.class);
		categoria.setPai(pai);
        return categoria;
	}
}
