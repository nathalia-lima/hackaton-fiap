package com.hackaton.fiap.api.dto.unidade;

import com.hackaton.fiap.core.domains.Endereco;

public record UnidadeResponse(Long id,
                              String nome,
                              String email,
                              String telefone,
                              Endereco endereco) {
}
