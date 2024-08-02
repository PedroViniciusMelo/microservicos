package org.ufape.preco.controlador;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.ufape.preco.basica.PoliticaPreco;
import org.ufape.preco.controlador.resquisicao.PoliticaPrecoRequest;
import org.ufape.preco.fachada.Preco;

import java.util.List;

@RestController
public class ControlladorPoliticaPreco {

    @Autowired
    private Preco preco;

    @PostMapping("/politica")
    public PoliticaPreco cadastrarPolitica(@Valid @RequestBody PoliticaPrecoRequest newObj) {
        return preco.salvarPolitica(newObj.converterParaClasseBasica());
    }

    @GetMapping("/politica")
    public List<PoliticaPreco> listarPoliticas() {
        return preco.listarPoliticas();
    }

    @GetMapping("/politica/{id}")
    public PoliticaPreco carregarPolitica(Long id) {
        return preco.encontrarPolitica(id);
    }

    @PostMapping("/politica/{id}")
    public PoliticaPreco atualizarPolitica(Long id, @Valid @RequestBody PoliticaPrecoRequest newObj) {
        return preco.atualizarPolitica(id, newObj.converterParaClasseBasica());
    }

    @PostMapping("/politica/{id}")
    public boolean apagarPolitica(Long id) {
        return preco.apagarPolitica(id);
    }

    
}
