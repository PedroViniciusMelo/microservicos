package com.topicos.estoque.fachada;

import com.topicos.estoque.cadastro.InterfaceEstoque;
import com.topicos.estoque.cadastro.InterfaceArmazem;
import com.topicos.estoque.basica.Estoque;
import com.topicos.estoque.basica.Armazem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Fachada {

    @Autowired
    private InterfaceEstoque interfaceEstoque;

    @Autowired
    private InterfaceArmazem interfaceArmazem;

    // interface de estoque
    public Estoque salvarEstoque(Estoque entidade) {
        return interfaceEstoque.salvarEstoque(entidade);
    }

    public boolean verificarProdutoNoCatalogo(long produtoId) { return interfaceEstoque.verificarProdutoNoCatalogo(produtoId);}

    public List<Estoque> listarEstoques() {
        return interfaceEstoque.listarEstoques();
    }

    public List<Estoque> listarEstoquesPeloArmazem(String name) {
        return interfaceEstoque.listarEstoquePeloArmazem(name);
    }

    public Estoque buscarEstoque(Long id) { return interfaceEstoque.buscarEstoque(id); }

    public Estoque atualizarEstoque(Long id, Estoque entidade) {
        return interfaceEstoque.atualizarEstoque(id, entidade);
    }

    public void apagarEstoque(Long id) {
        interfaceEstoque.apagarEstoque(id);
    }

    // intercafe de armazem
    public Armazem salvarArmazem(Armazem entidade) {
        return interfaceArmazem.salvarArmazem(entidade);
    }

    public Armazem buscarArmazem(Long id) {return interfaceArmazem.buscarArmazem(id);}

    public List<Armazem> listarArmazem() {
        return interfaceArmazem.listarArmazens();
    }

    public void apagarArmazem(Long id) {
        interfaceArmazem.apagarArmazem(id);
    }

    public Armazem atualizarArmazem(Long id, Armazem entidade) {
        return interfaceArmazem.atualizarArmazem(id, entidade);
    }

}
