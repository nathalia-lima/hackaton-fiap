package com.hackaton.fiap.api.mappers;

import com.hackaton.fiap.api.dto.medicamento.MedicamentoRequest;
import com.hackaton.fiap.core.domains.Medicamento;
import com.hackaton.fiap.infra.entity.MedicamentoEntity;
import org.springframework.stereotype.Component;

@Component
public class MedicamentoMappers {
    public Medicamento toMedicamento(MedicamentoRequest medicamentoRequest) {
        return new Medicamento(null, null, medicamentoRequest.nome(), medicamentoRequest.status());
    }

    public MedicamentoRequest toRequest(Medicamento medicamento) {
        return new MedicamentoRequest(medicamento.getNome(), medicamento.getStatus());
    }

    public MedicamentoEntity toMedicamentoEntity(MedicamentoRequest medicamento) {
        return new MedicamentoEntity(null, null, medicamento.nome(), medicamento.status());
    }
}
