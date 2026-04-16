package com.hackaton.fiap.api.mappers;

import com.hackaton.fiap.api.dto.unidade.UnidadeRequest;
import com.hackaton.fiap.api.dto.unidade.UnidadeResponse;
import com.hackaton.fiap.core.domains.Unidade;
import com.hackaton.fiap.infra.entity.UnidadeEntity;
import org.springframework.stereotype.Component;

@Component
public class UnidadeMappers {

    public Unidade toUnidade(UnidadeEntity unidadeEntity) {
        return new Unidade(
                unidadeEntity.getId(),
                unidadeEntity.getNome(),
                unidadeEntity.getEmail(),
                unidadeEntity.getSenha(),
                unidadeEntity.getTelefone(),
                EnderecoMapper.toEndereco(unidadeEntity.getEndereco())
        );
    }

    public UnidadeEntity toRequest(UnidadeRequest unidadeRequest) {
        return new UnidadeEntity(
                unidadeRequest.nome(),
                unidadeRequest.email(),
                unidadeRequest.senha(),
                unidadeRequest.telefone(),
                EnderecoMapper.toEnderecoEntity(unidadeRequest.endereco())
        );
    }

    public UnidadeResponse toResponse(UnidadeEntity save) {
        return new UnidadeResponse(
                save.getId(),
                save.getNome(),
                save.getEmail(),
                save.getTelefone(),
                EnderecoMapper.toEnderecoResponse(save.getEndereco())
        );
    }
}
