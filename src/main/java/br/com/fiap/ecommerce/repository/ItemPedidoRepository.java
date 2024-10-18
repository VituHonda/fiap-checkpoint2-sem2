package br.com.fiap.ecommerce.repository;

import br.com.fiap.ecommerce.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
