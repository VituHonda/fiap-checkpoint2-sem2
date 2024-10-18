package br.com.fiap.ecommerce.controller;

import br.com.fiap.ecommerce.dtos.produto.ProdutoRequestCreateDto;
import br.com.fiap.ecommerce.dtos.produto.ProdutoRequestUpdateDto;
import br.com.fiap.ecommerce.dtos.produto.ProdutoResponseDto;
import br.com.fiap.ecommerce.mapper.ProdutoMapper;
import br.com.fiap.ecommerce.repository.ProdutoRepository;
import br.com.fiap.ecommerce.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;
    private final ProdutoMapper produtoMapper;
    private final ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDto>> list() {
        List<ProdutoResponseDto> dtos = produtoService.list()
                .stream()
                .map(e -> produtoMapper.toDto(e))
                .toList();

        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDto> create(@RequestBody ProdutoRequestCreateDto dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        produtoMapper.toDto(
                                produtoService.save(produtoMapper.toModel(dto)))
                );
    }

    @PutMapping("{id}")
    public ResponseEntity<ProdutoResponseDto> update(
            @PathVariable Long id,
            @RequestBody ProdutoRequestUpdateDto dto) {
        if (! produtoService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }
        return ResponseEntity.ok()
                .body(
                        produtoMapper.toDto(
                                produtoService.save(produtoMapper.toModel(id, dto)))
                );
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (! produtoService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }

        produtoService.delete(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProdutoResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(
                        produtoService
                                .findById(id)
                                .map(e -> produtoMapper.toDto(e))
                                .orElseThrow(() -> new RuntimeException("Id inexistente"))
                );
    }
}
