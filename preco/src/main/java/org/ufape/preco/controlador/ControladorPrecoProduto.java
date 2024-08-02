package org.ufape.preco.controlador;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ufape.preco.basica.PrecoProduto;
import org.ufape.preco.controlador.resposta.PrecoProdutoResponse;
import org.ufape.preco.fachada.Preco;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControladorPrecoProduto {

    @Autowired
    private Preco cadastroPreco;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/preco")
    PrecoProduto cadastrarPreco (@Valid @RequestBody PrecoProduto newObj) {
        return cadastroPreco.salvarPreco(newObj);
    }

    @GetMapping("/preco/produto/{produtoId}")
    PrecoProdutoResponse carregarPreco(@PathVariable Long id) {
        return new PrecoProdutoResponse(cadastroPreco.encontrarPrecoProduto(id));
    }

    @GetMapping("/preco/produto/historico_precos/{produtoId}")
    List<PrecoProdutoResponse> listarPrecosDeProduto(@PathVariable Long produtoId) {
        List<PrecoProdutoResponse> response = new ArrayList<PrecoProdutoResponse>();
        for(PrecoProduto p : cadastroPreco.listarPrecosDeProduto(produtoId))
            response.add(new PrecoProdutoResponse(p));
        return response;
    }

    @GetMapping("/preco/produto/atualizar/{id}")
    PrecoProdutoResponse atualizarPreco(Long id, PrecoProduto newObj) {
        return new PrecoProdutoResponse(cadastroPreco.atualizarPrecoProduto(id, newObj));
    }


}
