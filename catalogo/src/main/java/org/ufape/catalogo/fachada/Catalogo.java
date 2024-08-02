package org.ufape.catalogo.fachada;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.ufape.catalogo.basica.Categoria;
import org.ufape.catalogo.basica.Produto;
import org.ufape.catalogo.cadastro.InterfaceCadastroCategoria;
import org.ufape.catalogo.cadastro.InterfaceCadastroProduto;

@Service
public class Catalogo {
	@Autowired
	private InterfaceCadastroCategoria cadastroCategoria;
	@Autowired
	private InterfaceCadastroProduto cadastroProduto;
	public Categoria salvarCategoria(Categoria entity) {
		return cadastroCategoria.salvarCategoria(entity);
	}
	public List<Categoria> listarCategorias() {
		return cadastroCategoria.listarCategorias();
	}
	public void apagarCategoria(Long id) {
		cadastroCategoria.apagarCategoria(id);
	}
	public Categoria encontrarCategoria(Long id) {
		return cadastroCategoria.encontrarCategoria(id);
	}
	public Categoria atualizarCategoria(Long id, Categoria categoria ) {
		return cadastroCategoria.atualizarCategoria(id, categoria);
	}
	public List<Produto> listarProdutos(String descricao) {
		return cadastroProduto.listarProdutos(descricao);
	}
	public List<Produto> listarProdutosPorCategoria(String nome) {
		return cadastroProduto.listarProdutosPorCategoria(nome);
	}
	public Produto salvarProduto(Produto entity) {
		return cadastroProduto.salvarProduto(entity);
	}
	public List<Produto> listarProdutos() {
		return cadastroProduto.listarProdutos();
	}
	public Produto encontrarProdutoId(Long id) {
		return cadastroProduto.encontrarProdutoId(id);
	}
	public void apagarProduto(Long id) {
		cadastroProduto.apagarProduto(id);
	}
}
