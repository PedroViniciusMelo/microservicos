package com.topicos.estoque.controlador.requisicao;

import com.topicos.estoque.config.SpringApplicationContext;
import com.topicos.estoque.basica.Endereco;
import com.topicos.estoque.basica.Armazem;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class ArmazemRequisicao {
    @NotBlank(message = "O nome do armazém não pode estar vazio.")
    @Size(min = 3, max = 100, message = "O nome do armazém deve ter entre 3 e 100 caracteres.")
    private String nome;

    @NotBlank(message = "A descrição do armazém não pode estar vazia.")
    @Size(max = 255, message = "A descrição do armazém pode ter no máximo 255 caracteres.")
    private String descricao;

    @NotNull(message = "O endereço não pode ser nulo.")
    @Valid
    private Endereco endereco;

    public Armazem converterParaClasseBasica() {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        Armazem armazem = modelMapper.map(this, Armazem.class);
        armazem.setNome(this.nome);
        armazem.setDescricao(this.descricao);
        armazem.setEndereco(this.endereco);

        return armazem;
    }
}
