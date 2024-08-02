package org.ufape.estoque.controlador;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ufape.estoque.basica.Armazem;
import org.ufape.estoque.controlador.requisicao.ArmazemRequest;
import org.ufape.estoque.controlador.resposta.ArmazemResponse;
import org.ufape.estoque.fachada.Estoque;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControladorArmazem {
    @Autowired
    private Estoque estoque;

    @PostMapping("/armazem")
    Armazem cadastrarArmazem (@Valid @RequestBody ArmazemRequest newObj) {
        return estoque.salvarArmazem(newObj.converterParaClasseBasica());
    }

    @GetMapping("/armazem")
    List<ArmazemResponse> listarArmazens() {
        List<ArmazemResponse> response = new ArrayList<ArmazemResponse>();
        for(Armazem a : estoque.listarArmazens())
            response.add(new ArmazemResponse(a));
        return response;
    }

    @GetMapping("/armazem/{id}")
    ArmazemResponse carregarArmazem(@PathVariable long id) {
        return new ArmazemResponse(estoque.encontrarArmazem(id));
    }

    @DeleteMapping("/armazem/{id}")
    void apagarArmazem(@PathVariable long id) {
        estoque.apagarArmazem(id);
    }

    @PutMapping("/armazem/{id}")
    ArmazemResponse atualizarArmazem(@PathVariable long id, @Valid @RequestBody ArmazemRequest newObj) {
        return new ArmazemResponse(estoque.atualizarArmazem(id, newObj.converterParaClasseBasica()));
    }

}
