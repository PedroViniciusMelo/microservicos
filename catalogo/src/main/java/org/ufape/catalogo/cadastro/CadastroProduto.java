package org.ufape.catalogo.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ufape.catalogo.basica.Produto;
import org.ufape.catalogo.repositorio.RepositorioProduto;

import java.util.List;
import java.util.Optional;


@Service
public class CadastroProduto implements InterfaceCadastroProduto {
	@Autowired
	private RepositorioProduto repositorioProduto;

	@Override
	public List<Produto> listarProdutos(String descricao) {
		return repositorioProduto.findByDescricaoContainingIgnoreCase(descricao);
	}

	@Override
	public List<Produto> listarProdutosPorCategoria(String nome) {
		return repositorioProduto.findByCategoria_nome(nome);
	}

	@Override
	public  Produto salvarProduto(Produto entity) {
		return repositorioProduto.save(entity);
	}

	@Override
	public List<Produto> listarProdutos() {
		return repositorioProduto.findAll();
	}

	@Override
	public Produto encontrarProdutoId(Long id) {
		Optional<Produto> optional = repositorioProduto.findById(id);

		if(optional.isPresent()) {
			return optional.get();
		} else {
			throw new ObjetoNaoEncontradoException("Não existe categoria com o id: " + id);
		}
	}

	@Override
	public void apagarProduto(Long id) {
		repositorioProduto.deleteById(id);
	}

	@Override
	public Produto atualizarProduto(Long id, Produto entity) {
		Optional<Produto> optional = repositorioProduto.findById(id);
		if  (optional.isPresent()) {
			Produto produto = optional.get();
			produto.setNome(entity.getNome());
			produto.setDescricao(entity.getDescricao());
			produto.setCategoria(entity.getCategoria());
			produto.setImagem(entity.getImagem());
			return repositorioProduto.save(produto);
		} else {
			throw new ObjetoNaoEncontradoException("Não existe categoria com o id: " + id);
		}
 	}
}
