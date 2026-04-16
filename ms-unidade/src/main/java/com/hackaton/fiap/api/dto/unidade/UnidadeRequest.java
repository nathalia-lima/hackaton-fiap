package com.hackaton.fiap.api.dto.unidade;

import com.hackaton.fiap.core.domains.Endereco;

public record UnidadeRequest(String nome,
                             String email,
                             String senha,
                             String telefone,
                             Endereco endereco) {
}
