package com.jb.supermercado.internal.produto.controller;

import com.jb.supermercado.internal.produto.dto.ProdutoRequestRecord;
import com.jb.supermercado.internal.produto.dto.ProdutoResponseRecord;
import com.jb.supermercado.internal.produto.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@Valid @RequestBody ProdutoRequestRecord produtoRequest) {
        this.produtoService.cadastrarProduto(produtoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseRecord>> listar() {
        return ResponseEntity.ok(this.produtoService.listarProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseRecord> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(this.produtoService.buscarProdutoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody ProdutoRequestRecord produtoRequest) {

        this.produtoService.atualizarProduto(id, produtoRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        this.produtoService.removerProduto(id);
        return ResponseEntity.noContent().build();
    }
}