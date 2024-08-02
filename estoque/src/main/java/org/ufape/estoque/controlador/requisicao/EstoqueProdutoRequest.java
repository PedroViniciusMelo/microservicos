package org.ufape.estoque.controlador.requisicao;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.ufape.estoque.basica.EstoqueProduto;

@Getter @Setter
public class EstoqueProdutoRequest {
    private long quantidade;
    private long idArmazem;
    private long idProduto;

    public EstoqueProduto converterParaClasseBasica() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, EstoqueProduto.class);
    }
}
