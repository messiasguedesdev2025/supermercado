package com.jb.supermercado.internal.produto.service;

import com.jb.supermercado.config.exception.RecursoNaoEncontradoException;
import com.jb.supermercado.config.exception.BusinessException;
import com.jb.supermercado.internal.produto.dto.ProdutoRequestRecord;
import com.jb.supermercado.internal.produto.dto.ProdutoResponseRecord;
import com.jb.supermercado.internal.produto.entity.ProdutoEntity;
import com.jb.supermercado.internal.produto.mapper.ProdutoMapperRecord;
import com.jb.supermercado.internal.produto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void cadastrarProduto(ProdutoRequestRecord produtoRequest) {

        if (produtoRepository.existsByNome(produtoRequest.nome())) {
            throw new BusinessException("Já existe um produto com esse nome");
        }

        ProdutoEntity produtoEntity = ProdutoMapperRecord.requestParaEntidade(produtoRequest);
        produtoRepository.save(produtoEntity);
    }

    public List<ProdutoResponseRecord> listarProdutos() {
        List<ProdutoEntity> produtoEntityList = produtoRepository.findAll();
        return ProdutoMapperRecord.entidadeParaResponseRecordList(produtoEntityList);
    }

    public ProdutoResponseRecord buscarProdutoPorId(Long id) {
        ProdutoEntity produtoEntity = produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado"));

        return ProdutoMapperRecord.entidadeParaResponse(produtoEntity);
    }

    public void atualizarProduto(Long id, ProdutoRequestRecord produtoRequest) {
        ProdutoEntity produtoEntity = produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado"));

        produtoEntity.setNome(produtoRequest.nome());
        produtoEntity.setDescricao(produtoRequest.descricao());
        produtoEntity.setPreco(produtoRequest.preco());
        produtoEntity.setQuantidadeEstoque(produtoRequest.quantidadeEstoque());
        produtoEntity.setStatus(produtoRequest.status());

        produtoRepository.save(produtoEntity);
    }

    public void removerProduto(Long id) {
        ProdutoEntity produtoEntity = produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado"));

        produtoRepository.delete(produtoEntity);
    }
}