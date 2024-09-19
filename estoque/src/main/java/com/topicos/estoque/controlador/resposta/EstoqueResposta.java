package com.topicos.estoque.controlador.resposta;

import com.topicos.estoque.config.SpringApplicationContext;
import com.topicos.estoque.basica.Estoque;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class EstoqueResposta {

    private long id;
    private int quantidade;

    private long produtoId;
    private long armazemId;

    public EstoqueResposta(Estoque estoque) {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        modelMapper.map(estoque, this);
    }
}
