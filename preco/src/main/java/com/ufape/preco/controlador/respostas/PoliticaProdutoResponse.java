package com.ufape.preco.controlador.respostas;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import com.ufape.preco.basica.PoliticaPreco;
import com.ufape.preco.config.SpringApplicationContext;

@Getter
@Setter
public class PoliticaProdutoResponse {

    private long id;
    private String tipo;
    private String descricao;
    private String regra;
    private String nome;

    public PoliticaPreco converterParaClasseBasica() {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        return modelMapper.map(this, PoliticaPreco.class);
    }
}
