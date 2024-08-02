package org.ufape.estoque.fachada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ufape.estoque.basica.Armazem;
import org.ufape.estoque.basica.EstoqueProduto;
import org.ufape.estoque.cadastro.InterfaceCadastroArmazem;
import org.ufape.estoque.cadastro.InterfaceCadastroEstoqueProduto;

import java.util.List;

@Service
public class Estoque {
    @Autowired
    private InterfaceCadastroArmazem cadastroArmazem;

    @Autowired
    private InterfaceCadastroEstoqueProduto cadastroEstoqueProduto;

    //service de Armazem
    public Armazem salvarArmazem(Armazem entity){
        return cadastroArmazem.salvarArmazem(entity);
    }
    public List<Armazem> listarArmazens(){
        return cadastroArmazem.listarArmazens();
    }
    public void apagarArmazem(Long id){
        cadastroArmazem.apagarArmazem(id);
    }
    public Armazem encontrarArmazem(Long id){
        return cadastroArmazem.encontrarArmazem(id);
    }
    public Armazem atualizarArmazem(Long id, Armazem armazem){
        return cadastroArmazem.atualizarArmazem(id, armazem);
    }

    //service de EstoqueProduto
    public EstoqueProduto adicionarProduto(Long idProduto, long quantidade, Long idArmazem){
        cadastroEstoqueProduto.adicionarProduto(idProduto, quantidade, idArmazem);
        return null;
    }

    public void removerProduto(Long idProduto, long quantidade, Long idArmazem){
        cadastroEstoqueProduto.removerProduto(idProduto, quantidade, idArmazem);
    }

    public long consultarQuantidadeProduto(Long idProduto, Long idArmazem){
        return cadastroEstoqueProduto.consultarQuantidadeProduto(idProduto, idArmazem);
    }

    public void apagarEstoqueProduto(Long idProduto, Long idArmazem){
        cadastroEstoqueProduto.apagarEstoqueProduto(idProduto, idArmazem);
    }



}




















