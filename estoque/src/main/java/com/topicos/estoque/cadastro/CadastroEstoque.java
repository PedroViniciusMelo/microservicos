package com.topicos.estoque.cadastro;

import com.topicos.core.ProductDTO;
import com.topicos.estoque.basica.Estoque;
import com.topicos.estoque.repositorio.EstoqueRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroEstoque implements InterfaceEstoque {

    @Autowired
    private EstoqueRepositorio estoqueRepositorio;

    private final RestTemplate restTemplate;

    @Value("${app.catalogo-service.host}")
    private String catalogoHost;

    public CadastroEstoque(RestTemplate restTemplate, DiscoveryClient discoveryClient) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Estoque salvarEstoque(Estoque entidade) {

        if (estoqueRepositorio.findByArmazem_id(entidade.getId()) != null) {
            return estoqueRepositorio.save(entidade);
        } else {
            throw new RegistroDuplicadoException("Estoque com id " + entidade.getId() + " já existe");
        }
    }

    @Override
    public List<Estoque> listarEstoquePeloArmazem(String nome) {
        return estoqueRepositorio.findByArmazem_nomeIgnoreCase(nome);
    }

    @Override
    public List<Estoque> listarEstoques() {
        return estoqueRepositorio.findAll();
    }

    @Override
    public void apagarEstoque(Long id) {
        Optional<Estoque> estoque = estoqueRepositorio.findById(id);

        if (estoque.isPresent()) {
            estoqueRepositorio.deleteById(id);
        } else {
            throw new ObjetoNaoEncontradoException("Estoque com id " + id + " nao encontrado");
        }
    }

    @Override
    public Estoque buscarEstoque(Long id) {
        Optional<Estoque> optional = estoqueRepositorio.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new ObjetoNaoEncontradoException("Não existe estoque com o id: " + id);
        }
    }

    @Override
    public Estoque atualizarEstoque(Long id, Estoque entidade) {
        Estoque estoque = estoqueRepositorio.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException("Estoque nao encontrado"));

        estoque.setQuantidade(entidade.getQuantidade());
        estoque.setProdutoId(entidade.getProdutoId());
        estoque.setArmazem(entidade.getArmazem());

        return estoqueRepositorio.save(estoque);
    }

    @Override
    public boolean verificarProdutoNoCatalogo(long produtoId) {
        String url = "http://catalogo/catalogo/produto/" + produtoId; // 'catalogo' é o nome do serviço registrado

        try {
            System.out.println("Verificando produto no catálogo: ID " + produtoId);
            ProductDTO produto = restTemplate.getForObject(url, ProductDTO.class);
            System.out.println("Produto encontrado no catálogo.");
            return true;
        } catch (HttpClientErrorException.NotFound e) {
            System.out.println("Produto não encontrado no catálogo: ID " + produtoId);
            return false;
        } catch (Exception e) {
            System.out.println("Erro ao verificar o produto no catálogo: " + e.getMessage());
            throw new RuntimeException("Erro ao verificar o produto no catálogo", e);
        }
    }

}
