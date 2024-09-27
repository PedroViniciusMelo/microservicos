package com.topicos.estoque.basica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "A rua não pode estar vazia.")
    @Size(min = 3, max = 100, message = "A rua deve ter entre 3 e 100 caracteres.")
    private String rua;

    @NotBlank(message = "O número não pode estar vazio.")
    @Size(max = 10, message = "O número pode ter no máximo 10 caracteres.")
    private String numero;

    @NotBlank(message = "O bairro não pode estar vazio.")
    @Size(min = 3, max = 50, message = "O bairro deve ter entre 3 e 50 caracteres.")
    private String bairro;

    @NotBlank(message = "A cidade não pode estar vazia.")
    @Size(min = 3, max = 50, message = "A cidade deve ter entre 3 e 50 caracteres.")
    private String cidade;

    @NotBlank(message = "O estado não pode estar vazio.")
    @Size(min = 2, max = 2, message = "O estado deve ter 2 caracteres.")
    private String estado;

    @NotBlank(message = "O país não pode estar vazio.")
    @Size(min = 2, max = 50, message = "O país deve ter entre 2 e 50 caracteres.")
    private String pais;

    @NotBlank(message = "O CEP não pode estar vazio.")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve seguir o formato 99999-999.")
    private String cep;
}
