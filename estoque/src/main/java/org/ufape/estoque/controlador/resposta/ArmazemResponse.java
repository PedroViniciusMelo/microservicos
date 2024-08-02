package org.ufape.estoque.controlador.resposta;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.ufape.estoque.basica.Armazem;
import org.ufape.estoque.config.SpringApplicationContext;

@Getter @Setter
public class ArmazemResponse {
    private long id;
    private String nome;
    private String localizacao;
    private long capacidade;

    public ArmazemResponse(Armazem armazem) {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        modelMapper.map(armazem, this);
    }
}
