package com.topicos.estoque.cadastro;

import java.io.Serial;

public class RegistroDuplicadoException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public RegistroDuplicadoException(String message) {
        super(message);
    }
}
