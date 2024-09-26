package com.ufape.preco.controlador.respostas;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import com.ufape.preco.basica.PrecoProduto;
import com.ufape.preco.config.SpringApplicationContext;

@Getter @Setter
public class PrecoProdutoResponse {

    private Long id;
    private Double valor;
    private Long produtoId;
    private String dataInicio;
    private String dataFim;

    public PrecoProdutoResponse(PrecoProduto precoProduto) {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        modelMapper.map(precoProduto, this);
    }
}
