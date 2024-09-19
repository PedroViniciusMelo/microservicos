package com.topicos.estoque.cadastro;

import com.topicos.estoque.basica.Armazem;
import com.topicos.estoque.basica.Endereco;
import com.topicos.estoque.repositorio.ArmazemRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroArmazem implements InterfaceArmazem {

    @Autowired
    private ArmazemRepositorio armazemRepositorio;

    public Armazem salvarArmazem(Armazem entidade) {

        if (armazemRepositorio.findByNomeIgnoreCase(entidade.getNome()) == null) {
            return armazemRepositorio.save(entidade);
        } else {
            throw new RegistroDuplicadoException("O armazém [" + entidade.getNome() + "] já se encontra cadastrado no sistema.");
        }
    }

    public List<Armazem> listarArmazens() {
        return armazemRepositorio.findAll();
    }

    public void apagarArmazem(Long id) {
        if (armazemRepositorio.findById(id).isPresent()) {
            armazemRepositorio.deleteById(id);
        } else {
            throw new ObjetoNaoEncontradoException("Armazem com o " + id + " nao encontrado.");
        }
    }

    public Armazem buscarArmazem(Long id) {
        Optional<Armazem> optional = armazemRepositorio.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new ObjetoNaoEncontradoException("Não existe armazém com o id: " + id);
        }
    }

    @Override
    public Armazem atualizarArmazem(Long id, Armazem entidade) {
       Armazem armazem = armazemRepositorio.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException("Armazem com o " + id + " nao encontrado."));

        armazem.setNome(entidade.getNome());
        armazem.setDescricao(entidade.getDescricao());

        if (armazem.getEndereco() != null) {
            Endereco endereco = armazem.getEndereco();
            Endereco novoEndereco = entidade.getEndereco();

            endereco.setRua(novoEndereco.getRua());
            endereco.setNumero(novoEndereco.getNumero());
            endereco.setBairro(novoEndereco.getBairro());
            endereco.setCidade(novoEndereco.getCidade());
            endereco.setEstado(novoEndereco.getEstado());
            endereco.setPais(novoEndereco.getPais());
            endereco.setCep(novoEndereco.getCep());
        } else {
            armazem.setEndereco(entidade.getEndereco());
        }

        return armazemRepositorio.save(armazem);
    }
}
