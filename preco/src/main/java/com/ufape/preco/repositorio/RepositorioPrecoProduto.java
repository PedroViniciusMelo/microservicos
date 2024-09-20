package com.ufape.preco.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ufape.preco.basica.PrecoProduto;

import java.util.List;

public interface RepositorioPrecoProduto extends JpaRepository<PrecoProduto, Long> {

    @Query( "SELECT p " +
            "FROM PrecoProduto p " +
            "WHERE p.produtoId = ?1 " +
            "and p.dataFim is null" )
    PrecoProduto findByProdutoId(Long produtoId);

    List<PrecoProduto> findAllByProdutoId(Long produtoId);


}
