package org.ufape.estoque.controlador.requisicao;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.ufape.estoque.basica.Armazem;
import org.ufape.estoque.config.SpringApplicationContext;

@Getter @Setter
public class ArmazemRequest {
    private String nome;
    private String localizacao;
    private long capacidade;

    public Armazem converterParaClasseBasica() {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        return modelMapper.map(this, Armazem.class);
    }
}
