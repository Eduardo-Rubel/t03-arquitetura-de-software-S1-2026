package com.fag.lucasmartins.arquitetura_software.service;

import com.fag.lucasmartins.arquitetura_software.controller.dto.ProdutoRequest;
import com.fag.lucasmartins.arquitetura_software.controller.dto.ProdutoResponse;

public interface ProdutoService {

    ProdutoResponse cadastrar(ProdutoRequest request);
}
