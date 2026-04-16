package com.hackaton.fiap.core.usecase.unidade;

import com.hackaton.fiap.api.dto.unidade.UnidadeRequest;
import com.hackaton.fiap.api.dto.unidade.UnidadeResponse;
import com.hackaton.fiap.api.mappers.UnidadeMappers;
import com.hackaton.fiap.infra.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

@Service
public class CriarUnidade {
    private final UnidadeRepository unidadeRepository;
    private final UnidadeMappers unidadeMappers;

    public CriarUnidade(UnidadeRepository unidadeRepository, UnidadeMappers unidadeMappers) {
        this.unidadeRepository = unidadeRepository;
        this.unidadeMappers = unidadeMappers;
    }

    public UnidadeResponse executar(UnidadeRequest unidade) {
        return unidadeMappers.toResponse(unidadeRepository.save(unidadeMappers.toRequest(unidade)));
    }
}
