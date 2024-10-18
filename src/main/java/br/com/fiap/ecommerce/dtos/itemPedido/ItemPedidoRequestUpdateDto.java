package br.com.fiap.ecommerce.dtos.itemPedido;


import br.com.fiap.ecommerce.model.ItemPedido;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

@Getter
@Setter
public class ItemPedidoRequestUpdateDto {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final ModelMapper modelMapper = new ModelMapper();

    private Long idPedido;
    private Long idProduto;
    private BigDecimal quantidade;
    private BigDecimal valorTotal;

    public ItemPedido toModel(Long id) {
        ItemPedido result = modelMapper.map(this, ItemPedido.class);
        result.setId(id);
        return result;
    }
}
