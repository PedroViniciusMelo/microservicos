package com.topicos.estoque.controlador;

import com.topicos.estoque.controlador.requisicao.ArmazemRequisicao;
import com.topicos.estoque.controlador.resposta.ArmazemResposta;
import com.topicos.estoque.fachada.Fachada;
import com.topicos.estoque.basica.Armazem;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/estoque")
public class ControladorArmazem {
    @Autowired
    private Fachada fachada;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/armazem")
    Armazem salvarArmazem(@Validated @RequestBody ArmazemRequisicao newObj) {
        Armazem endereco = newObj.converterParaClasseBasica();
        System.out.println("Mensagem para o console");
        System.out.println(endereco);
        return fachada.salvarArmazem(newObj.converterParaClasseBasica());
    }

    @GetMapping("/armazem")
    List<ArmazemResposta> listarArmazens() {
        List<ArmazemResposta> response = new ArrayList<>();

        for (Armazem armazem : fachada.listarArmazem()) {
            response.add(new ArmazemResposta(armazem));
        }

        return response;
    }

    @GetMapping("/armazem/{id}")
    ArmazemResposta buscarArmazem(@PathVariable long id) {
        Armazem armazem = fachada.buscarArmazem(id);
        return new ArmazemResposta(armazem);
    }

    @DeleteMapping("/armazem/{id}")
    public void apagarArmazem(@PathVariable long id) {
        fachada.apagarArmazem(id);
    }

    @PutMapping("/armazem/{id}")
    public Armazem updateStock(@PathVariable long id, @RequestBody ArmazemRequisicao newObj) {
        return fachada.atualizarArmazem(id, newObj.converterParaClasseBasica());
    }
}
