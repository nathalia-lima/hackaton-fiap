package com.hackaton.fiap.api.controller;

import com.hackaton.fiap.api.dto.medicamento.MedicamentoRequest;
import com.hackaton.fiap.api.dto.unidade.UnidadeRequest;
import com.hackaton.fiap.api.dto.unidade.UnidadeResponse;
import com.hackaton.fiap.core.usecase.medicamento.CriarMedicamento;
import com.hackaton.fiap.core.usecase.unidade.CriarUnidade;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {
    private final CriarUnidade unidade;
    private final CriarMedicamento medicamento;

    public UnidadeController(CriarUnidade unidade, CriarMedicamento medicamento) {
        this.unidade = unidade;
        this.medicamento = medicamento;
    }

    @PostMapping
    public UnidadeResponse criarUnidade(@RequestBody UnidadeRequest request) {
        return unidade.executar(request);
    }

    @PostMapping("/{unidadeId}/medicamento")
    public void criarMedicamento(@PathVariable("unidadeId") Long unidadeId, @RequestBody MedicamentoRequest medicamentoRequest) {
        medicamento.executar(unidadeId, medicamentoRequest);
    }

}
