package br.com.fiap.ecommerce.dtos.produto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import br.com.fiap.ecommerce.model.Produto;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoRequestUpdateDto {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final ModelMapper modelMapper = new ModelMapper();

    private String nome;
    private BigDecimal valor;

    public Produto toModel(Long id) {
        Produto result = modelMapper.map(this, Produto.class);
        result.setId(id);
        return result;
    }   
}
