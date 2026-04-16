package com.hackaton.fiap.api.dto.medicamento;

import com.hackaton.fiap.core.domains.Status;

public record MedicamentoRequest(
        String nome,
        Status status
) {
}
