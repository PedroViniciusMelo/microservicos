package com.ufape.preco.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ufape.preco.basica.PoliticaPreco;
import com.ufape.preco.repositorio.RepositorioPoliticaPreco;

import java.util.List;
import java.util.Optional;

@Service
public class ControladorPoliticaPreco implements InterfaceCadastroPoliticaPreco{

    @Autowired
    private RepositorioPoliticaPreco repositorioPoliticaPreco;

    @Override
    public PoliticaPreco salvarPolitica(PoliticaPreco entity) {
        if(repositorioPoliticaPreco.findByNomeIgnoreCase(entity.getNome()) == null) {
            return repositorioPoliticaPreco.save(entity);
        } else {
            throw new RuntimeException("A política ["+ entity.getNome() + "] já se encontra cadastrada no sistema.");
        }
    }

    @Override
    public PoliticaPreco encontrarPolitica(Long id) {
        Optional<PoliticaPreco> optional = repositorioPoliticaPreco.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            throw new ObjetoNaoEncontradoException("Não existe política com o id: " + id);
        }
    }

    @Override
    public PoliticaPreco atualizarPolitica(Long id, PoliticaPreco politica) {
        Optional<PoliticaPreco> optional = repositorioPoliticaPreco.findById(id);
        if  (optional.isPresent()) {
            PoliticaPreco politicaPreco = optional.get();
            politicaPreco.setNome(politica.getNome());
            politicaPreco.setDescricao(politica.getDescricao());
            politicaPreco.setRegra(politica.getRegra());
            return repositorioPoliticaPreco.save(politicaPreco);
        } else {
            throw new ObjetoNaoEncontradoException("Não existe política com o id: " + id);
        }
    }

    @Override
    public boolean apagarPolitica(Long id) {
        Optional<PoliticaPreco> optional = repositorioPoliticaPreco.findById(id);
        if(optional.isPresent()) {
            repositorioPoliticaPreco.deleteById(id);
            return true;
        } else {
            throw new ObjetoNaoEncontradoException("Não existe política com o id: " + id);
        }
    }

    @Override
    public List<PoliticaPreco> listarPoliticas() {
        return repositorioPoliticaPreco.findAll();
    }
}
