package br.com.fiap.ecommerce.dtos.itemPedido;

import br.com.fiap.ecommerce.model.ItemPedido;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

@Getter
@Setter
public class ItemPedidoResponseDto {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final ModelMapper modelMapper = new ModelMapper();

    private Long id;
    private Long idPedido;
    private Long idProduto;
    private BigDecimal quantidade;
    private BigDecimal valorTotal;

    public ItemPedidoResponseDto toDto(ItemPedido itemPedido) {
        return modelMapper.map(itemPedido, ItemPedidoResponseDto.class);
    }
}
