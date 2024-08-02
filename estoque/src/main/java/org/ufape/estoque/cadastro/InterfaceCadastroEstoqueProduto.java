package org.ufape.estoque.cadastro;

import org.ufape.estoque.basica.EstoqueProduto;

public interface InterfaceCadastroEstoqueProduto {

    EstoqueProduto adicionarProduto(Long idProduto, long quantidade, Long idArmazem);

    void removerProduto(Long idProduto, long quantidade, Long idArmazem);

    long consultarQuantidadeProduto(Long idProduto, Long idArmazem);

    void apagarEstoqueProduto(Long idProduto, Long idArmazem);

}
