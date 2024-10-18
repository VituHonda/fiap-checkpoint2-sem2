package br.com.fiap.ecommerce.dtos.produto;

import lombok.*;
import org.modelmapper.ModelMapper;

import br.com.fiap.ecommerce.model.Produto;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoRequestCreateDto {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final ModelMapper modelMapper = new ModelMapper();

    private String nome;
    private BigDecimal valor;

    public Produto toModel() {
        return modelMapper.map(this, Produto.class);
    }
    
}
