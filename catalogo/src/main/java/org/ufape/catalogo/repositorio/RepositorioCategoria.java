package org.ufape.catalogo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ufape.catalogo.basica.Categoria;


public interface RepositorioCategoria extends JpaRepository<Categoria, Long> {
	Categoria findByNomeIgnoreCase(String nome);
}
