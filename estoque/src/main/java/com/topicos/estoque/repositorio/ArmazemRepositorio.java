package com.topicos.estoque.repositorio;

import com.topicos.estoque.basica.Armazem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArmazemRepositorio extends JpaRepository<Armazem, Long> {
    Armazem findByNomeIgnoreCase(String nome);

    List<Armazem> findByEndereco_paisIgnoreCase(String pais);

    List<Armazem> findByEndereco_estadoIgnoreCase(String estado);

    List<Armazem> findByEndereco_cidadeIgnoreCase(String cidade);

    List<Armazem> findByEndereco_cepIgnoreCase(String cep);
}
