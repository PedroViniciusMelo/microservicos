package org.ufape.preco.controlador.resposta;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.ufape.catalogo.config.SpringApplicationContext;
import org.ufape.preco.basica.PoliticaPreco;

@Getter
@Setter
public class PoliticaProdutoResponse {

    private long id;
    private String tipo;
    private String descricao;
    private String regra;

    public PoliticaPreco converterParaClasseBasica() {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        return modelMapper.map(this, PoliticaPreco.class);
    }
}
