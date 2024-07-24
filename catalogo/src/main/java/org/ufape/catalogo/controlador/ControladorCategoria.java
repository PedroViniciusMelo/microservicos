package org.ufape.catalogo.controlador;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import org.ufape.catalogo.basica.Categoria;
import org.ufape.catalogo.controlador.requisicao.CategoriaRequest;
import org.ufape.catalogo.controlador.resposta.CategoriaResponse;
import org.ufape.catalogo.fachada.Catalogo;

@RestController
public class ControladorCategoria {
	@Autowired
	private Catalogo catalogo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@PostMapping("/categoria")
	Categoria cadastrarCategoria (@Valid @RequestBody CategoriaRequest newObj) {
		return catalogo.salvarCategoria(newObj.converterParaClasseBasica());
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

}
