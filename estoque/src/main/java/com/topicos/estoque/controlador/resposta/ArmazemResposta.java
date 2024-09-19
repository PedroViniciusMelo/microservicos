package com.topicos.estoque.controlador.resposta;

import com.topicos.estoque.config.SpringApplicationContext;
import com.topicos.estoque.basica.Endereco;
import com.topicos.estoque.basica.Armazem;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class ArmazemResposta {
    private long id;
    private String nome;
    private String descricao;

    private Endereco endereco;

    public ArmazemResposta(Armazem armazem) {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        modelMapper.map(armazem, this);

        if (armazem.getEndereco() != null) {
            modelMapper.map(armazem.getEndereco(), this);
            this.endereco = armazem.getEndereco();
            this.id = armazem.getId();
        }

    }
}
