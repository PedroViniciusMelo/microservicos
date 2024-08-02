package org.ufape.estoque.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ufape.estoque.basica.Armazem;
import org.ufape.estoque.repositorio.RepositorioArmazem;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroArmazem implements InterfaceCadastroArmazem {
    @Autowired
    private RepositorioArmazem repositorioArmazem;

    @Override
    public Armazem salvarArmazem(Armazem entity) {
        if (repositorioArmazem.findByNomeIgnoreCase(entity.getNome()) == null) {
            return repositorioArmazem.save(entity);
        } else {
            throw new RegistroDuplicadoException("O armazém [" + entity.getNome() + "] já se encontra cadastrado no sistema.");
        }
    }

    @Override
    public List<Armazem> listarArmazens() {
        return repositorioArmazem.findAll();
    }

    @Override
    public void apagarArmazem(Long id) {
        repositorioArmazem.deleteById(id);
    }

    @Override
    public Armazem encontrarArmazem(Long id) {
        Optional<Armazem> optional = repositorioArmazem.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new ObjetoNaoEncontradoException("Não existe armazém com o id: " + id);
        }
    }

    @Override
    public Armazem atualizarArmazem(Long id, Armazem armazem) {
        Optional<Armazem> optional = repositorioArmazem.findById(id);
        if (optional.isPresent()) {
            Armazem armazemAtual = optional.get();
            armazemAtual.setNome(armazem.getNome());
            armazemAtual.setLocalizacao(armazem.getLocalizacao());
            armazemAtual.setCapacidade(armazem.getCapacidade());
            return repositorioArmazem.save(armazemAtual);
        } else {
            throw new ObjetoNaoEncontradoException("Não existe armazém com o id: " + id);
        }
    }
}
