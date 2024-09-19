package com.topicos.estoque.controlador.requisicao;

import com.topicos.estoque.config.SpringApplicationContext;
import com.topicos.estoque.basica.Endereco;
import com.topicos.estoque.basica.Armazem;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class ArmazemRequisicao {
    private String nome;
    private String descricao;

    //endereco
    private Endereco endereco;

    public Armazem converterParaClasseBasica() {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        Armazem armazem = modelMapper.map(this, Armazem.class);
        armazem.setNome(this.nome);
        armazem.setDescricao(this.descricao);
        armazem.setEndereco(this.endereco);

        return armazem;
    }
}
