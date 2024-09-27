package com.ufape.preco.cadastro;

import com.ufape.preco.basica.PrecoProduto;

import java.util.List;

public interface InterfaceCadastroPrecoProduto {

        PrecoProduto salvarPreco(PrecoProduto entity);

        List<PrecoProduto> listarPrecosDeProduto(Long produtoId);

        //void apagarPreco(Long id);

        PrecoProduto encontrarPrecoProduto(Long id);

        PrecoProduto atualizarPrecoProduto(Long id, PrecoProduto preco);

    PrecoProduto salvarPrecoParaProduto(Long produtoId);
}
