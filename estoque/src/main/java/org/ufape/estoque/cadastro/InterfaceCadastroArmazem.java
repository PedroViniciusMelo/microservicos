package org.ufape.estoque.cadastro;

import org.ufape.estoque.basica.Armazem;

import java.util.List;

public interface InterfaceCadastroArmazem {

    Armazem salvarArmazem(Armazem entity);

    List<Armazem> listarArmazens();

    void apagarArmazem(Long id);

    Armazem encontrarArmazem(Long id);

    Armazem atualizarArmazem(Long id, Armazem armazem);

}
