package org.ufape.estoque.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.ufape.estoque.cadastro.ObjetoNaoEncontradoException;
import org.ufape.estoque.cadastro.RegistroDuplicadoException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class TratadorDeExecucaoCustomizada {
    @ExceptionHandler(RegistroDuplicadoException.class)
    protected ResponseEntity<Object> tratarExcecaoRegistroDuplicado(RegistroDuplicadoException ex) {
        Map<String, String> resposta = new HashMap<String, String>();
        resposta.put("tipo", "RegistroDuplicado");
        resposta.put("mensagem", ex.getMessage());

        Map<String, Object> erro = new HashMap<>();
        erro.put("erro", resposta);

        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ObjetoNaoEncontradoException.class)
    protected ResponseEntity<Object> tratarExcecaoObjetoNaoEncontrado(ObjetoNaoEncontradoException ex) {
        Map<String, String> resposta = new HashMap<String, String>();
        resposta.put("tipo", "RecursoNaoEncontrado");
        resposta.put("mensagem", ex.getMessage());

        Map<String, Object> erro = new HashMap<>();
        erro.put("erro", resposta);

        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }
}
