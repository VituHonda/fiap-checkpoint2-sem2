package br.com.fiap.ecommerce.dtos.itemPedido;

import br.com.fiap.ecommerce.model.ItemPedido;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.math.BigDecimal;

@Getter
@Setter
public class ItemPedidoRequestCreateDto {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final ModelMapper modelMapper = new ModelMapper();
    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    private Long idPedido;
    private Long idProduto;
    private BigDecimal quantidade;
    private BigDecimal valorTotal;

    public ItemPedido toModel() {
        return modelMapper.map(this, ItemPedido.class);
    }
}
