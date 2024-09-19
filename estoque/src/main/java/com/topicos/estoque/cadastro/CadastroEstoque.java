package com.topicos.estoque.cadastro;

import com.topicos.estoque.basica.Estoque;
import com.topicos.estoque.repositorio.EstoqueRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroEstoque implements InterfaceEstoque {

    @Autowired
    private EstoqueRepositorio estoqueRepositorio;

    @Override
    public Estoque salvarEstoque(Estoque entidade) {

        if (estoqueRepositorio.findByArmazem_id(entidade.getId()) != null) {
            return estoqueRepositorio.save(entidade);
        } else {
            throw new RegistroDuplicadoException("Estoque com id " + entidade.getId() + " já existe");
        }
    }

    @Override
    public List<Estoque> listarEstoquePeloArmazem(String nome) {
        return estoqueRepositorio.findByArmazem_nomeIgnoreCase(nome);
    }

    @Override
    public List<Estoque> listarEstoques() {
        return estoqueRepositorio.findAll();
    }

    @Override
    public void apagarEstoque(Long id) {
        Optional<Estoque> estoque = estoqueRepositorio.findById(id);

        if (estoque.isPresent()) {
            estoqueRepositorio.deleteById(id);
        } else {
            throw new ObjetoNaoEncontradoException("Estoque com id " + id + " nao encontrado");
        }
    }

    @Override
    public Estoque buscarEstoque(Long id) {
        Optional<Estoque> optional = estoqueRepositorio.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new ObjetoNaoEncontradoException("Não existe estoque com o id: " + id);
        }
    }

    @Override
    public Estoque atualizarEstoque(Long id, Estoque entidade) {
        Estoque estoque = estoqueRepositorio.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException("Estoque nao encontrado"));

        estoque.setQuantidade(entidade.getQuantidade());
        estoque.setProdutoId(entidade.getProdutoId());
        estoque.setArmazem(entidade.getArmazem());

        return estoqueRepositorio.save(estoque);
    }
}
