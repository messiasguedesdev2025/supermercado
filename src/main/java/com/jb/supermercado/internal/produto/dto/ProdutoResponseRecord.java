package com.jb.supermercado.internal.produto.dto;

public record ProdutoResponseRecord(
        Long id,
        String nome,
        String descricao,
        Double preco,
        Integer quantidadeEstoque,
        String status
) {
}