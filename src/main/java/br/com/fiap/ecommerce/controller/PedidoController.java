package br.com.fiap.ecommerce.controller;

import br.com.fiap.ecommerce.dtos.pedido.PedidoRequestCreateDto;
import br.com.fiap.ecommerce.dtos.pedido.PedidoRequestUpdateDto;
import br.com.fiap.ecommerce.dtos.pedido.PedidoResponseDto;
import br.com.fiap.ecommerce.mapper.PedidoMapper;
import br.com.fiap.ecommerce.repository.PedidoRepository;
import br.com.fiap.ecommerce.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService pedidoService;
    private final PedidoMapper pedidoMapper;
    private final PedidoRepository pedidoRepository;

    @GetMapping
    public ResponseEntity<List<PedidoResponseDto>> list() {
        List<PedidoResponseDto> dtos = pedidoService.list()
                .stream()
                .map(e -> pedidoMapper.toDto(e))
                .toList();

        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDto> create(@RequestBody PedidoRequestCreateDto dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        pedidoMapper.toDto(
                                pedidoService.save(pedidoMapper.toModel(dto)))
                );
    }

    @PutMapping("{id}")
    public ResponseEntity<PedidoResponseDto> update(
            @PathVariable Long id,
            @RequestBody PedidoRequestUpdateDto dto) {
        if (! pedidoService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }
        return ResponseEntity.ok()
                .body(
                        pedidoMapper.toDto(
                                pedidoService.save(pedidoMapper.toModel(id, dto)))
                );
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (! pedidoService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }

        pedidoService.delete(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<PedidoResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(
                        pedidoService
                                .findById(id)
                                .map(e -> pedidoMapper.toDto(e))
                                .orElseThrow(() -> new RuntimeException("Id inexistente"))
                );
    }
}