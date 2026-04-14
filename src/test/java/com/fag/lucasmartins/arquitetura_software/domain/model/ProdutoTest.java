package com.fag.lucasmartins.arquitetura_software.domain.model;

import com.fag.lucasmartins.arquitetura_software.domain.exception.RegraDeNegocioException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProdutoTest {

    @Test
    void deveAplicarDescontoDeAtacadoQuandoEstoqueForMaiorOuIgualACinquenta() {
        Produto produto = new Produto("Notebook", 200.0, 50);

        produto.prepararParaCadastro();

        assertEquals(180.0, produto.getPrecoFinal());
    }

    @Test
    void deveImpedirCadastroDeProdutoPremiumComPrecoMenorQueOCriterioMinimo() {
        Produto produto = new Produto("Notebook Premium", 90.0, 10);

        assertThrows(RegraDeNegocioException.class, produto::prepararParaCadastro);
    }
}
