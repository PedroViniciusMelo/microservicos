package org.ufape.estoque.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ufape.estoque.basica.Armazem;

import java.util.List;

public interface RepositorioArmazem extends JpaRepository<Armazem, Long> {
    Armazem findByNomeIgnoreCase(String nome);
    List<Armazem> findByLocalizacaoIgnoreCase(String localizacao);
}
