package org.ufape.estoque.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ufape.estoque.basica.Armazem;
import org.ufape.estoque.basica.EstoqueProduto;
import org.ufape.estoque.repositorio.RepositorioArmazem;
import org.ufape.estoque.repositorio.RepositorioEstoqueProduto;

@Service
public class CadastroEstoqueProduto implements InterfaceCadastroEstoqueProduto {
   @Autowired
    private RepositorioEstoqueProduto repositorioEstoqueProduto;

   @Autowired
   private RepositorioArmazem repositorioArmazem;

/**   @Autowired
   private RepositorioProduto repositorioProduto;
*/
    @Override
    public  EstoqueProduto adicionarProduto(Long idProduto, long quantidade, Long idArmazem){

        /** Verificar se o produto existe
        Produto produto = produtoRepository.findById(idProduto)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

         */
        // Verificar se o armazém existe
        Armazem armazem = repositorioArmazem.findById(idArmazem)
                .orElseThrow(() -> new RuntimeException("Armazém não encontrado"));

        // Verificar se já existe um estoque para este produto neste armazém
        EstoqueProduto estoqueProduto = repositorioEstoqueProduto.findByProdutoIdAndArmazemId(idProduto, idArmazem);

        if (estoqueProduto == null) {
            estoqueProduto = new EstoqueProduto();
            estoqueProduto.setProdutoId(idProduto);
            estoqueProduto.setArmazem(armazem);
            estoqueProduto.setQuantidade(quantidade);
        } else {
            //Atualiza quantidade no estoque, caso ele ja exista
            estoqueProduto.setQuantidade(estoqueProduto.getQuantidade() + quantidade);
        }
        return repositorioEstoqueProduto.save(estoqueProduto);
    }

    @Override
    public void removerProduto(Long idProduto, long quantidade, Long idArmazem) {
        EstoqueProduto estoqueProduto = repositorioEstoqueProduto.findByProdutoIdAndArmazemId(idProduto, idArmazem);
        if (estoqueProduto != null && estoqueProduto.getQuantidade() >= quantidade) {
            //Atualiza quantidade no estoque subtraindo a quantidade que tem, pela que quantidade que eu quero retirar
            estoqueProduto.setQuantidade(estoqueProduto.getQuantidade() - quantidade);
            repositorioEstoqueProduto.save(estoqueProduto);
        } else {
            throw new RuntimeException("Estoque insuficiente ou não encontrado");
        }
    }

    @Override
    public long consultarQuantidadeProduto(Long idProduto, Long idArmazem) {
        EstoqueProduto estoqueProduto = repositorioEstoqueProduto.findByProdutoIdAndArmazemId(idProduto, idArmazem);
        return (estoqueProduto != null) ? estoqueProduto.getQuantidade() : 0;
    }

    @Override
    public void apagarEstoqueProduto(Long idProduto, Long idArmazem) {
        EstoqueProduto estoqueProduto = repositorioEstoqueProduto.findByProdutoIdAndArmazemId(idProduto, idArmazem);
        if (estoqueProduto != null) {
            repositorioEstoqueProduto.delete(estoqueProduto);
        } else {
            throw new RuntimeException("Estoque não encontrado");
        }
    }

}
