package com.ufape.preco.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ufape.preco.basica.PrecoProduto;
import com.ufape.preco.repositorio.RepositorioPrecoProduto;

import java.util.Date;
import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
=======
>>>>>>> 43634c0 (refatoracao)

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
<<<<<<< HEAD
        PrecoProduto optional = repositorioPrecoProduto.findByProdutoId(produtoId);
        if(optional != null) {
            return (List<PrecoProduto>) repositorioPrecoProduto.findByProdutoId(produtoId);
        } else {
            throw new ObjetoNaoEncontradoException("Não existe preço para o produto com o id: " + produtoId);
        }
=======
        return repositorioPrecoProduto.findAllByProdutoId(produtoId);
>>>>>>> 43634c0 (refatoracao)
    }

    @Override
    public PrecoProduto encontrarPrecoProduto(Long id) {
<<<<<<< HEAD
        Optional<PrecoProduto> optional = repositorioPrecoProduto.findById(id);

        if(optional.isPresent()) {
            return optional.get();
        } else {
            throw new ObjetoNaoEncontradoException("Não existe preço com o id: " + id);
        }
=======
        return repositorioPrecoProduto.findByProdutoId(id);
>>>>>>> 43634c0 (refatoracao)
    }

    @Override
    public PrecoProduto atualizarPrecoProduto(Long id, PrecoProduto preco) {
<<<<<<< HEAD
        Optional<PrecoProduto> optional = repositorioPrecoProduto.findById(id);
        if  (optional.isPresent()) {
            PrecoProduto precoProduto = optional.get();
            precoProduto.setValor(preco.getValor());
            precoProduto.setDataFim(preco.getDataFim());
            return repositorioPrecoProduto.save(precoProduto);
        } else {
            throw new ObjetoNaoEncontradoException("Não existe preço com o id: " + id);
        }
=======
        PrecoProduto precoAtual = repositorioPrecoProduto.findByProdutoId(id);
        Date dataFim = new Date();
        precoAtual.setDataFim(dataFim);
        repositorioPrecoProduto.save(precoAtual);
        return repositorioPrecoProduto.save(preco);
>>>>>>> 43634c0 (refatoracao)
    }

}
