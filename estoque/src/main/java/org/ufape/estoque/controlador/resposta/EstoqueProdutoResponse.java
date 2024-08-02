package org.ufape.estoque.controlador.resposta;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.ufape.estoque.basica.EstoqueProduto;
import org.ufape.estoque.config.SpringApplicationContext;

@Getter @Setter
public class EstoqueProdutoResponse {
    private long id;
    private long quantidade;
    private long idArmazem;
    private long idProduto;

    public EstoqueProdutoResponse(EstoqueProduto estoqueProduto) {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        modelMapper.map(estoqueProduto, this);
        this.idArmazem = estoqueProduto.getArmazem().getId();
        this.idProduto = estoqueProduto.getProdutoId();
    }

}
