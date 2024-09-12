package org.ufape.catalogo.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ufape.catalogo.basica.Categoria;
import org.ufape.catalogo.repositorio.RepositorioCategoria;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroCategoria implements InterfaceCadastroCategoria {
	@Autowired
	private RepositorioCategoria repositorioCategoria ;

	@Override
	public Categoria salvarCategoria(Categoria entity) {
		if(repositorioCategoria.findByNomeIgnoreCase(entity.getNome()) == null) {
			return repositorioCategoria.save(entity);	
		} else {
			throw new RegistroDuplicadoException("A categoria ["+ entity.getNome() + "] já se encontra cadastrada no sistema.");
		}
	}

	@Override
	public List<Categoria> listarCategorias() {
		return repositorioCategoria.findAll();
	}

	@Override
	public void apagarCategoria(Long id) {
		repositorioCategoria.deleteById(id);
	}

	@Override
	public Categoria encontrarCategoria(Long id) {
		Optional<Categoria> optional = repositorioCategoria.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			throw new ObjetoNaoEncontradoException("Não existe categoria com o id: " + id);
		}
	}

	@Override
	public Categoria atualizarCategoria(Long id, Categoria categoria) {
		Optional<Categoria> optional = repositorioCategoria.findById(id);
		if(optional.isPresent()) {
			Categoria categoriaAtual = optional.get();
			categoriaAtual.setNome(categoria.getNome());
			categoriaAtual.setDescricao(categoria.getDescricao());
			categoriaAtual.setIcone(categoria.getIcone());
			return repositorioCategoria.save(categoriaAtual);
		} else {
			throw new ObjetoNaoEncontradoException("Não existe categoria com o id: " + id);
		}
 	}
}
