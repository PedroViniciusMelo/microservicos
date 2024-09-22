package org.ufape.catalogo.controlador;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ufape.catalogo.basica.Categoria;
import org.ufape.catalogo.controlador.requisicao.CategoriaRequest;
import org.ufape.catalogo.controlador.resposta.CategoriaResponse;
import org.ufape.catalogo.fachada.Catalogo;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalogo")
public class ControladorCategoria {
	@Autowired
	private Catalogo catalogo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@PostMapping("/categoria")
	Categoria cadastrarCategoria (@Valid @RequestBody CategoriaRequest newObj) {
		if (newObj.getPai() == null)
			return catalogo.salvarCategoria(newObj.converterParaClasseBasica(null));
		Categoria pai = catalogo.encontrarCategoria(newObj.getPai());
		return catalogo.salvarCategoria(newObj.converterParaClasseBasica(pai));
	}

	@GetMapping("/categoria")
	List<CategoriaResponse> listarCategorias() {
		List<CategoriaResponse> response = new ArrayList<CategoriaResponse>();
		for(Categoria c : catalogo.listarCategorias())
			response.add(new CategoriaResponse(c));
		return response;
	}
	
	@GetMapping("/categoria/{id}")
	CategoriaResponse carregarCategoria(@PathVariable long id) {
		return new CategoriaResponse(catalogo.encontrarCategoria(id));
	}

	@DeleteMapping("/categoria/{id}")
	void apagarCategoria(@PathVariable long id) {
		catalogo.apagarCategoria(id);
	}

	@PutMapping("/categoria/{id}")
	CategoriaResponse atualizarCategoria(@PathVariable long id, @Valid @RequestBody CategoriaRequest newObj) {
		if (newObj.getPai() == null)
			return new CategoriaResponse(catalogo.atualizarCategoria(id, newObj.converterParaClasseBasica(null)));
		Categoria pai = catalogo.encontrarCategoria(newObj.getPai());
		return new CategoriaResponse(catalogo.atualizarCategoria(id, newObj.converterParaClasseBasica(pai)));
	}
}
