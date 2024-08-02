package org.ufape.preco.cadastro;

import org.ufape.preco.basica.PoliticaPreco;

import java.util.List;

public interface InterfaceCadastroPoliticaPreco {

    PoliticaPreco salvarPolitica(PoliticaPreco entity);

    PoliticaPreco encontrarPolitica(Long id);

    PoliticaPreco atualizarPolitica(Long id, PoliticaPreco politica);

    boolean apagarPolitica(Long id);

    List<PoliticaPreco> listarPoliticas();
}
