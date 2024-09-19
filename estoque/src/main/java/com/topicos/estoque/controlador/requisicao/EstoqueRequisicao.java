package com.topicos.estoque.controlador.requisicao;

import com.topicos.estoque.config.SpringApplicationContext;
import com.topicos.estoque.basica.Estoque;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class EstoqueRequisicao {
    private int quantidade;

    private long produtoId;
    private long armazem;

    public Estoque converterParaClasseBasica() {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        return modelMapper.map(this, Estoque.class);
    }
}
