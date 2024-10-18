package br.com.fiap.ecommerce.dtos.produto;

import lombok.*;
import org.modelmapper.ModelMapper;

import br.com.fiap.ecommerce.model.Produto;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoResponseDto {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final ModelMapper modelMapper = new ModelMapper();

    private Long id;
    private String nome;
    private BigDecimal valor;

    public ProdutoResponseDto toDto(Produto produto) {
        return modelMapper.map(produto, ProdutoResponseDto.class);
    }
}
