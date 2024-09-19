package com.topicos.estoque.repositorio;

import com.topicos.estoque.basica.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstoqueRepositorio extends JpaRepository<Estoque, Long> {

    List<Estoque> findByArmazem_nomeIgnoreCase(String nome);

    List<Estoque> findByArmazem_id(long armazem_id);
}
