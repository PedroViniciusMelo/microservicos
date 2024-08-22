package org.ufape.preco.controlador.resquisicao;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import org.ufape.preco.basica.PoliticaPreco;
import org.ufape.preco.config.SpringApplicationContext;

@Getter
@Setter
public class PoliticaPrecoRequest {

    @NotBlank(message = "O tipo é obrigatório")
    private String tipo;

    private String descricao;

    @NotBlank(message = "A regra é obrigatória")
    private String regra;

    public PoliticaPreco converterParaClasseBasica() {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        return modelMapper.map(this, PoliticaPreco.class);
    }


}
