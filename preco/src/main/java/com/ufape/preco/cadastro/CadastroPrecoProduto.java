package com.ufape.preco.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ufape.preco.basica.PrecoProduto;
import com.ufape.preco.repositorio.RepositorioPrecoProduto;

import java.util.Date;
import java.util.List;

@Service
public class CadastroPrecoProduto implements InterfaceCadastroPrecoProduto {

    @Autowired
    private RepositorioPrecoProduto repositorioPrecoProduto;

    @Override
    public PrecoProduto salvarPreco(PrecoProduto entity) {
        Date dataInicio = new Date();
        entity.setDataInicio(dataInicio);
        return repositorioPrecoProduto.save(entity);
    }

    @Override
    public List<PrecoProduto> listarPrecosDeProduto(Long produtoId) {
        return repositorioPrecoProduto.findAllByProdutoId(produtoId);
    }

    @Override
    public PrecoProduto encontrarPrecoProduto(Long id) {
        return repositorioPrecoProduto.findByProdutoId(id);
    }

    @Override
    public PrecoProduto atualizarPrecoProduto(Long id, PrecoProduto preco) {
        PrecoProduto precoAtual = repositorioPrecoProduto.findByProdutoId(id);
        Date dataFim = new Date();
        precoAtual.setDataFim(dataFim);
        repositorioPrecoProduto.save(precoAtual);
        return repositorioPrecoProduto.save(preco);
    }

}
