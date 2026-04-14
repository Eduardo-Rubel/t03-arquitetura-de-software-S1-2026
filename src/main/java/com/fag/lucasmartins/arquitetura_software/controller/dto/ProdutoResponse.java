package com.fag.lucasmartins.arquitetura_software.controller.dto;

public class ProdutoResponse {

    private final String mensagem;
    private final String nome;
    private final Integer estoque;
    private final Double preco;
    private final Double precoFinal;

    public ProdutoResponse(String mensagem, String nome, Integer estoque, Double preco, Double precoFinal) {
        this.mensagem = mensagem;
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
        this.precoFinal = precoFinal;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getNome() {
        return nome;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public Double getPreco() {
        return preco;
    }

    public Double getPrecoFinal() {
        return precoFinal;
    }
}
