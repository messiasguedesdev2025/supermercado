package com.jb.supermercado.internal.produto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record ProdutoRequestRecord(

        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "A descrição é obrigatória")
        String descricao,

        @NotNull(message = "O preço é obrigatório")
        @Positive(message = "O preço deve ser maior que zero")
        Double preco,

        @NotNull(message = "A quantidade em estoque é obrigatória")
        @PositiveOrZero(message = "A quantidade em estoque não pode ser negativa")
        Integer quantidadeEstoque,

        @NotBlank(message = "O status é obrigatório")
        String status
) {
}