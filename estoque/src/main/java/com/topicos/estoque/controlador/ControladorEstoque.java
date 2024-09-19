package com.topicos.estoque.controlador;

import com.topicos.estoque.controlador.requisicao.EstoqueRequisicao;
import com.topicos.estoque.controlador.resposta.EstoqueResposta;
import com.topicos.estoque.cadastro.ObjetoNaoEncontradoException;
import com.topicos.estoque.fachada.Fachada;
import com.topicos.estoque.basica.Estoque;
import com.topicos.estoque.basica.Armazem;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/estoque")
public class ControladorEstoque {
    @Autowired
    private Fachada fachada;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/estoque")
    public Estoque salvarEstoque(@Validated @RequestBody EstoqueRequisicao newObj) {
        Armazem armazem = fachada.buscarArmazem(newObj.getArmazem());

        if (armazem == null) {
            throw new ObjetoNaoEncontradoException("Armazem com id " + newObj.getArmazem() + " nao encontrado");
        }

        Estoque estoque = newObj.converterParaClasseBasica();
        estoque.setArmazem(armazem);

        return fachada.salvarEstoque(estoque);
    }

    @GetMapping("/estoque")
    public List<EstoqueResposta> listarEstoques() {
        List<EstoqueResposta> response = new ArrayList<>();

        for (Estoque estoque : fachada.listarEstoques()) {
            response.add(new EstoqueResposta(estoque));
        }

        return response;
    }

    @GetMapping("/estoque/{id}")
    public EstoqueResposta buscarEstoque(@PathVariable long id) {
        Estoque estoque = fachada.buscarEstoque(id);
        return new EstoqueResposta(estoque);
    }

    @GetMapping("/estoque/armazem/{nome}")
    public List<EstoqueResposta> listarEstoquesPeloArmazem(@PathVariable String name) {
        List<EstoqueResposta> response = new ArrayList<>();

        for (Estoque estoque : fachada.listarEstoquesPeloArmazem(name)) {
            response.add(new EstoqueResposta(estoque));
        }

        return response;
    }

    @DeleteMapping("/estoque/{id}")
    public void apagarEstoque(@PathVariable long id) {
        fachada.apagarEstoque(id);
    }

    @PutMapping("/estoque/{id}")
    Estoque atualizarEstoque(@PathVariable long id, @RequestBody EstoqueRequisicao newObj) {
        Armazem armazem = fachada.buscarArmazem(newObj.getArmazem());

        if (armazem == null) {
            throw new ObjetoNaoEncontradoException("Armazem com id " + newObj.getArmazem() + " nao encontrado");
        }

        Estoque estoque = newObj.converterParaClasseBasica();
        estoque.setArmazem(armazem);

        return fachada.atualizarEstoque(id, estoque);
    }
}
