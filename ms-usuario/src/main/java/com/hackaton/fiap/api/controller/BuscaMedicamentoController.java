package com.hackaton.fiap.api.controller;

import com.hackaton.fiap.api.dto.BuscaMedicamento;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/busca")
public class BuscaMedicamentoController {

    private final BuscaMedicamento buscaService;

    public BuscaMedicamentoController(BuscaMedicamento buscaService) {
        this.buscaService = buscaService;
    }

    @GetMapping("/medicamento")
    public String procurar(@RequestParam String nome) {
        return buscaService.buscarRemedio(nome);
    }
}
