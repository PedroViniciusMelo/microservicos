package org.ufape.preco.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ufape.preco.basica.PoliticaPreco;
import org.ufape.preco.repositorio.RepositorioPoliticaPreco;

import java.util.List;

@Service
public class ControladorPoliticaPreco implements InterfaceCadastroPoliticaPreco{

    @Autowired
    private RepositorioPoliticaPreco repositorioPoliticaPreco;

    @Override
    public PoliticaPreco salvarPolitica(PoliticaPreco entity) {
        return repositorioPoliticaPreco.save(entity);
    }

    @Override
    public PoliticaPreco encontrarPolitica(Long id) {
        return repositorioPoliticaPreco.findById(id).orElse(null);
    }

    @Override
    public PoliticaPreco atualizarPolitica(Long id, PoliticaPreco politica) {
        return repositorioPoliticaPreco.save(politica);
    }

    @Override
    public boolean apagarPolitica(Long id) {
        if (repositorioPoliticaPreco.existsById(id)) {
            repositorioPoliticaPreco.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<PoliticaPreco> listarPoliticas() {
        return repositorioPoliticaPreco.findAll();
    }
}
