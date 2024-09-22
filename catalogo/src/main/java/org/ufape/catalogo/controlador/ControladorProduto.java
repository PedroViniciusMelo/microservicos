package org.ufape.catalogo.controlador;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ufape.catalogo.basica.Produto;
import org.ufape.catalogo.controlador.requisicao.ProdutoRequest;
import org.ufape.catalogo.controlador.resposta.ProdutoResponse;
import org.ufape.catalogo.fachada.Catalogo;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalogo")
public class ControladorProduto {
	@Autowired
	private Catalogo catalogo;

	@Autowired
	private ModelMapper modelMapper;


	@PostMapping("/produto")
	Produto cadastrarProduto (@Valid @RequestBody ProdutoRequest newObj) {
		return catalogo.salvarProduto(newObj.converterParaClasseBasica(catalogo.encontrarCategoria(newObj.getCategoria())));
	}


	@GetMapping("/produto")
	List<ProdutoResponse> listarProdutos() {
		List<ProdutoResponse> response = new ArrayList<ProdutoResponse>();
		for(Produto c : catalogo.listarProdutos())
			response.add(new ProdutoResponse(c));
		return response;
	}


	@PutMapping("/produto/{id}")
	ProdutoResponse atualizarProduto(@PathVariable long id, @Valid @RequestBody ProdutoRequest newObj) {
		Produto c = catalogo.atualizarProduto(id, newObj.converterParaClasseBasica(catalogo.encontrarCategoria(newObj.getCategoria())));
		return new ProdutoResponse(c);
	}

	@GetMapping("/produto/categoria/{categoria}")
	List<ProdutoResponse> listarProdutosPorCategoria(@PathVariable String categoria) {
		List<ProdutoResponse> response = new ArrayList<ProdutoResponse>();
		for(Produto c : catalogo.listarProdutosPorCategoria(categoria))
			response.add(new ProdutoResponse(c));
		return response;
	}

	@GetMapping("/produto/descricao/{descricao}")
	List<ProdutoResponse> listarProdutosPorDescricao(@PathVariable String descricao) {
		List<ProdutoResponse> response = new ArrayList<ProdutoResponse>();
		for(Produto c : catalogo.listarProdutos(descricao))
			response.add(new ProdutoResponse(c));
		return response;
	}

	@GetMapping("/produto/{id}")
	ProdutoResponse encontrarProdutoId(@PathVariable long id) {
		return new ProdutoResponse(catalogo.encontrarProdutoId(id));
	}

	@DeleteMapping("/produto/{id}")
	void apagarProduto(@PathVariable long id) {
		catalogo.apagarProduto(id);
	}

}
