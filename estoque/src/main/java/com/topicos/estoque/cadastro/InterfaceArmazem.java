package com.topicos.estoque.cadastro;

import com.topicos.estoque.basica.Armazem;

import java.util.List;

public interface InterfaceArmazem {

    Armazem salvarArmazem(Armazem entidade);

    List<Armazem> listarArmazens();

    void apagarArmazem(Long id);

    Armazem buscarArmazem(Long id);

    Armazem atualizarArmazem(Long id, Armazem entidade);
}
