package com.ufape.preco.fachada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ufape.preco.basica.PoliticaPreco;
import com.ufape.preco.basica.PrecoProduto;
import com.ufape.preco.cadastro.InterfaceCadastroPoliticaPreco;
import com.ufape.preco.cadastro.InterfaceCadastroPrecoProduto;

import java.util.List;


@Service
public class Preco {

    //Preco Service
    @Autowired
    private InterfaceCadastroPrecoProduto cadastroPreco;

    public PrecoProduto salvarPreco(PrecoProduto entity) {
        return cadastroPreco.salvarPreco(entity);
    }

    public PrecoProduto encontrarPrecoProduto(Long id) {
        return cadastroPreco.encontrarPrecoProduto(id);
    }

    public PrecoProduto atualizarPrecoProduto(Long id, PrecoProduto preco) {
        return cadastroPreco.atualizarPrecoProduto(id, preco);
    }

    public List<PrecoProduto> listarPrecosDeProduto(Long produtoId) {
        return cadastroPreco.listarPrecosDeProduto(produtoId);
    }

    //Politica Service
    @Autowired
    private InterfaceCadastroPoliticaPreco cadastroPolitica;

    public PoliticaPreco salvarPolitica(PoliticaPreco entity) {
        return cadastroPolitica.salvarPolitica(entity);
    }

    public PoliticaPreco encontrarPolitica(Long id) {
        return cadastroPolitica.encontrarPolitica(id);
    }

    public PoliticaPreco atualizarPolitica(Long id, PoliticaPreco politica) {
        return cadastroPolitica.atualizarPolitica(id, politica);
    }

    public boolean apagarPolitica(Long id) {
        return cadastroPolitica.apagarPolitica(id);
    }

    public List<PoliticaPreco> listarPoliticas() {
        return cadastroPolitica.listarPoliticas();
    }
}
