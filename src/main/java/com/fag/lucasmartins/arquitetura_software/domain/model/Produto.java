package com.fag.lucasmartins.arquitetura_software.domain.model;

import com.fag.lucasmartins.arquitetura_software.domain.exception.RegraDeNegocioException;

public class Produto {

    private static final double PRECO_MINIMO_PREMIUM = 100.0;
    private static final int ESTOQUE_MINIMO_ATACADO = 50;
    private static final double DESCONTO_ATACADO = 0.10;

    private final String nome;
    private final double preco;
    private final int estoque;
    private double precoFinal;

    public Produto(String nome, Double preco, Integer estoque) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new RegraDeNegocioException("Nome do produto e obrigatorio.");
        }
        if (preco == null || preco <= 0) {
            throw new RegraDeNegocioException("Preco do produto deve ser maior que zero.");
        }
        if (estoque == null || estoque < 0) {
            throw new RegraDeNegocioException("Estoque do produto deve ser informado.");
        }

        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.precoFinal = preco;
    }

    public void prepararParaCadastro() {
        validarPrecoMinimoParaProdutoPremium();
        aplicarDescontoDeAtacado();
    }

    private void validarPrecoMinimoParaProdutoPremium() {
        if (nome.toLowerCase().contains("premium") && preco < PRECO_MINIMO_PREMIUM) {
            throw new RegraDeNegocioException("Produtos Premium nao podem custar menos de R$ 100,00.");
        }
    }

    private void aplicarDescontoDeAtacado() {
        if (estoque >= ESTOQUE_MINIMO_ATACADO) {
            precoFinal = preco - (preco * DESCONTO_ATACADO);
        }
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }
}
