package com.ufape.preco.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ufape.preco.basica.PoliticaPreco;

public interface RepositorioPoliticaPreco extends JpaRepository<PoliticaPreco, Long>{

    PoliticaPreco findByNomeIgnoreCase(String nome);


}
