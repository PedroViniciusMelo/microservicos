package com.ufape.preco.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ufape.preco.basica.PrecoProduto;
import com.ufape.preco.repositorio.RepositorioPrecoProduto;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        PrecoProduto optional = repositorioPrecoProduto.findByProdutoId(produtoId);
        if(optional != null) {
            return (List<PrecoProduto>) repositorioPrecoProduto.findByProdutoId(produtoId);
        } else {
            throw new ObjetoNaoEncontradoException("Não existe preço para o produto com o id: " + produtoId);
        }
    }

    @Override
    public PrecoProduto encontrarPrecoProduto(Long id) {
        Optional<PrecoProduto> optional = repositorioPrecoProduto.findById(id);

        if(optional.isPresent()) {
            return optional.get();
        } else {
            throw new ObjetoNaoEncontradoException("Não existe preço com o id: " + id);
        }
    }

    @Override
    public PrecoProduto atualizarPrecoProduto(Long id, PrecoProduto preco) {
        Optional<PrecoProduto> optional = repositorioPrecoProduto.findById(id);
        if  (optional.isPresent()) {
            PrecoProduto precoProduto = optional.get();
            precoProduto.setValor(preco.getValor());
            precoProduto.setDataFim(preco.getDataFim());
            return repositorioPrecoProduto.save(precoProduto);
        } else {
            throw new ObjetoNaoEncontradoException("Não existe preço com o id: " + id);
        }
    }

}
