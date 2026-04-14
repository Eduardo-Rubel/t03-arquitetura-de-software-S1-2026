package com.fag.lucasmartins.arquitetura_software.service;

import com.fag.lucasmartins.arquitetura_software.controller.dto.ProdutoRequest;
import com.fag.lucasmartins.arquitetura_software.controller.dto.ProdutoResponse;
import com.fag.lucasmartins.arquitetura_software.domain.model.Produto;
import com.fag.lucasmartins.arquitetura_software.domain.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoResponse cadastrar(ProdutoRequest request) {
        Produto produto = new Produto(request.getNome(), request.getPreco(), request.getEstoque());
        produto.prepararParaCadastro();
        produtoRepository.salvar(produto);

        return new ProdutoResponse(
                "Produto cadastrado com sucesso!",
                produto.getNome(),
                produto.getEstoque(),
                produto.getPreco(),
                produto.getPrecoFinal()
        );
    }
}
