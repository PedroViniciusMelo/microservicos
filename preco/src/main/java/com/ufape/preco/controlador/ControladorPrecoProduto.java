package com.ufape.preco.controlador;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ufape.preco.basica.PrecoProduto;
import com.ufape.preco.controlador.respostas.PrecoProdutoResponse;
import com.ufape.preco.fachada.Preco;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/preco")
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
    PrecoProdutoResponse carregarPreco(@PathVariable Long produtoId) {
        return new PrecoProdutoResponse(cadastroPreco.encontrarPrecoProduto(produtoId));
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
