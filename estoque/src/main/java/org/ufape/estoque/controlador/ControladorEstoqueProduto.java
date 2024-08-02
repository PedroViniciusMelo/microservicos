package org.ufape.estoque.controlador;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.ufape.estoque.basica.EstoqueProduto;
import org.ufape.estoque.controlador.requisicao.EstoqueProdutoRequest;
import org.ufape.estoque.controlador.resposta.EstoqueProdutoResponse;
import org.ufape.estoque.fachada.Estoque;

@RestController
public class ControladorEstoqueProduto {
    @Autowired
    private Estoque estoque;

    @PostMapping("/estoqueProduto")
    EstoqueProduto cadastrarEstoqueProduto (@Valid @RequestBody EstoqueProdutoRequest newObj) {
        EstoqueProduto estoqueProduto = estoque.adicionarProduto(newObj.getIdProduto(), newObj.getQuantidade(), newObj.getIdArmazem());
        return estoqueProduto;
    }

    @DeleteMapping("/estoqueProduto")
    void apagarEstoqueProduto(@Valid @RequestBody EstoqueProdutoRequest newObj) {
        estoque.apagarEstoqueProduto(newObj.getIdProduto(), newObj.getIdArmazem());
    }

    @PostMapping("/estoqueProduto/remover")
    void removerEstoqueProduto(@Valid @RequestBody EstoqueProdutoRequest newObj) {
        estoque.removerProduto(newObj.getIdProduto(), newObj.getQuantidade(), newObj.getIdArmazem());
    }

    @PostMapping("/estoqueProduto/consultar")
    long consultarEstoqueProduto(@Valid @RequestBody EstoqueProdutoRequest newObj) {
        return estoque.consultarQuantidadeProduto(newObj.getIdProduto(), newObj.getIdArmazem());
    }


}
