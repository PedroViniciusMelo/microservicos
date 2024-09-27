package com.topicos.estoque.controlador.requisicao;

import com.topicos.estoque.config.SpringApplicationContext;
import com.topicos.estoque.basica.Estoque;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class EstoqueRequisicao {

    @Min(value = 1, message = "A quantidade mínima de um produto no estoque é 1.")
    @NotNull(message = "Estoque não pode ser criado sem quantidade.")
    private int quantidade;

    @NotNull(message = "O ID do produto não pode ser nulo.")
    private long produtoId;

    @NotNull(message = "O ID do armazém não pode ser nulo.")
    private long armazem;

    public Estoque converterParaClasseBasica() {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        return modelMapper.map(this, Estoque.class);
    }
}
