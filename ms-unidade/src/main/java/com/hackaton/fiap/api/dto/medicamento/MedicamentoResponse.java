package com.hackaton.fiap.api.dto.medicamento;

import com.hackaton.fiap.core.domains.Status;

public record MedicamentoResponse(
        Long id,
        String nome,
        Status status
) {
}
