package com.ufape.preco.controlador.requisicao;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import com.ufape.preco.config.SpringApplicationContext;
import com.ufape.preco.basica.PrecoProduto;

@Getter @Setter
public class PrecoProdutoRequest {

    @NotBlank(message = "O valor é obrigatório")
    private Double valor;
    @NotBlank(message = "E necessario informar o produto")
    private Long produtoId;

    public PrecoProduto converterParaClasseBasica() {
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
        return modelMapper.map(this, PrecoProduto.class);
    }
}
