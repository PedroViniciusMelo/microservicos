package com.topicos.estoque.cadastro;

import com.topicos.estoque.basica.Estoque;

import java.util.List;

public interface InterfaceEstoque {
    Estoque salvarEstoque(Estoque entidade);

    List<Estoque> listarEstoques();

    List<Estoque> listarEstoquePeloArmazem(String nome);

    Estoque atualizarEstoque(Long id, Estoque entidade);

    Estoque buscarEstoque(Long id);

    void apagarEstoque(Long id);

    boolean verificarProdutoNoCatalogo(long produtoId);
}
