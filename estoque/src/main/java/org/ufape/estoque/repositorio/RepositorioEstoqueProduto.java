package org.ufape.estoque.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ufape.estoque.basica.EstoqueProduto;

public interface RepositorioEstoqueProduto extends JpaRepository<EstoqueProduto, Long> {
    EstoqueProduto findByProdutoIdAndArmazemId(long idProduto, long idArmazem);
}
