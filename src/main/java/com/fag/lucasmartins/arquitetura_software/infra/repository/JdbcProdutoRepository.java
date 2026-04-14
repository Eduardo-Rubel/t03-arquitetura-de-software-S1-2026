package com.fag.lucasmartins.arquitetura_software.infra.repository;

import com.fag.lucasmartins.arquitetura_software.domain.model.Produto;
import com.fag.lucasmartins.arquitetura_software.domain.repository.ProdutoRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcProdutoRepository implements ProdutoRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcProdutoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void salvar(Produto produto) {
        String sql = "INSERT INTO produto (nome, preco, preco_final, estoque) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, produto.getNome(), produto.getPreco(), produto.getPrecoFinal(), produto.getEstoque());
    }
}
