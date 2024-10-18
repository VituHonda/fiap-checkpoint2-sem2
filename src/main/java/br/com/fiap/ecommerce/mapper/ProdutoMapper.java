package br.com.fiap.ecommerce.mapper;


import br.com.fiap.ecommerce.dtos.produto.ProdutoRequestCreateDto;
import br.com.fiap.ecommerce.dtos.produto.ProdutoRequestUpdateDto;
import br.com.fiap.ecommerce.dtos.produto.ProdutoResponseDto;
import br.com.fiap.ecommerce.model.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {
    @Autowired
    private ModelMapper modelMapper;

    public ProdutoResponseDto toDto(Produto produto) {
        return modelMapper.map(produto, ProdutoResponseDto.class);
    }

    public Produto toModel(ProdutoRequestCreateDto dto) {
        return modelMapper.map(dto, Produto.class);
    }

    public Produto toModel(Long id, ProdutoRequestUpdateDto dto) {
        Produto result = modelMapper.map(dto, Produto.class);
        result.setId(id);
        return result;
    }

}
