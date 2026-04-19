package com.jb.supermercado.internal.produto.mapper;

import com.jb.supermercado.internal.produto.dto.ProdutoRequestRecord;
import com.jb.supermercado.internal.produto.dto.ProdutoResponseRecord;
import com.jb.supermercado.internal.produto.entity.ProdutoEntity;

import java.util.ArrayList;
import java.util.List;

public class ProdutoMapperRecord {

    public static ProdutoEntity requestParaEntidade(ProdutoRequestRecord produtoRequest) {
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setNome(produtoRequest.nome());
        produtoEntity.setDescricao(produtoRequest.descricao());
        produtoEntity.setPreco(produtoRequest.preco());
        produtoEntity.setQuantidadeEstoque(produtoRequest.quantidadeEstoque());
        produtoEntity.setStatus(produtoRequest.status());
        return produtoEntity;
    }

    public static ProdutoResponseRecord entidadeParaResponse(ProdutoEntity produtoEntity) {
        return new ProdutoResponseRecord(
                produtoEntity.getId(),
                produtoEntity.getNome(),
                produtoEntity.getDescricao(),
                produtoEntity.getPreco(),
                produtoEntity.getQuantidadeEstoque(),
                produtoEntity.getStatus()
        );
    }

    public static List<ProdutoResponseRecord> entidadeParaResponseRecordList(List<ProdutoEntity> produtoEntityList) {
        List<ProdutoResponseRecord> produtoResponseRecordArrayList = new ArrayList<>();

        for (ProdutoEntity produtoEntity : produtoEntityList) {
            produtoResponseRecordArrayList.add(entidadeParaResponse(produtoEntity));
        }

        return produtoResponseRecordArrayList;
    }
}