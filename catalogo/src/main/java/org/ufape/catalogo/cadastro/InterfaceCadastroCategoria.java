package org.ufape.catalogo.cadastro;

import org.ufape.catalogo.basica.Categoria;

import java.util.List;


public interface InterfaceCadastroCategoria {

	Categoria salvarCategoria(Categoria entity);

	List<Categoria> listarCategorias();

	void apagarCategoria(Long id);

	Categoria encontrarCategoria(Long id);

	Categoria atualizarCategoria(Long id, Categoria categoria);

}