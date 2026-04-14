package com.fag.lucasmartins.arquitetura_software.controller;

import com.fag.lucasmartins.arquitetura_software.controller.dto.ProdutoRequest;
import com.fag.lucasmartins.arquitetura_software.controller.dto.ProdutoResponse;
import com.fag.lucasmartins.arquitetura_software.domain.exception.RegraDeNegocioException;
import com.fag.lucasmartins.arquitetura_software.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarProduto(@RequestBody ProdutoRequest request) {
        try {
            ProdutoResponse response = produtoService.cadastrar(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (RegraDeNegocioException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(erro("Erro ao processar requisicao: " + e.getMessage()));
        }
    }

    private Map<String, String> erro(String mensagem) {
        return Collections.singletonMap("erro", mensagem);
    }
}
