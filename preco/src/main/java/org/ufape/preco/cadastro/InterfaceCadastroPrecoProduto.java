package org.ufape.preco.cadastro;


import org.ufape.preco.basica.PrecoProduto;

import java.util.List;

public interface InterfaceCadastroPrecoProduto {

        PrecoProduto salvarPreco(PrecoProduto entity);

        List<PrecoProduto> listarPrecosDeProduto(Long produtoId);

        //void apagarPreco(Long id);

        PrecoProduto encontrarPrecoProduto(Long id);

        PrecoProduto atualizarPrecoProduto(Long id, PrecoProduto preco);
}
