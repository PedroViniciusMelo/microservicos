package org.ufape.catalogo.cadastro;

import org.ufape.catalogo.basica.Categoria;

import java.util.List;


public interface InterfaceCadastroCategoria {

	Categoria salvarCategoria(Categoria entity);

	List<Categoria> listarCategorias();

	void apagarCategoria(Long id);

	void apagarCategoria(Categoria entity);

	Categoria encontrarCategoria(Long id);

}