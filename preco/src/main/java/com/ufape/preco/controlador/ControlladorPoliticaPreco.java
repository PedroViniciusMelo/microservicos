package com.ufape.preco.controlador;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ufape.preco.basica.PoliticaPreco;
import com.ufape.preco.controlador.requisicao.PoliticaPrecoRequest;
import com.ufape.preco.fachada.Preco;

import java.util.List;

@RestController
@RequestMapping("/preco")
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

    @DeleteMapping("/politica/{id}")
    public boolean apagarPolitica(Long id) {
        return preco.apagarPolitica(id);
    }

    
}
