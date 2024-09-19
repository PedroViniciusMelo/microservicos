package com.topicos.estoque.cadastro;

import java.io.Serial;

public class ObjetoNaoEncontradoException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ObjetoNaoEncontradoException(String message) {
        super(message);
    }
}
