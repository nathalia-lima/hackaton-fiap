package com.hackaton.fiap.api.mappers;

import com.hackaton.fiap.core.domains.Endereco;
import com.hackaton.fiap.infra.entity.EnderecoEntity;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {
        public static EnderecoEntity toEnderecoEntity(Endereco endereco) {
            return new EnderecoEntity(
                    endereco.getCep(),
                    endereco.getRua(),
                    endereco.getNumero(),
                    endereco.getComplemento(),
                    endereco.getBairro(),
                    endereco.getLocalidade(),
                    endereco.getUf()
            );
        }

        public static Endereco toEndereco(EnderecoEntity enderecoEntity) {
            return new Endereco(
                    enderecoEntity.getCep(),
                    enderecoEntity.getRua(),
                    enderecoEntity.getNumero(),
                    enderecoEntity.getComplemento(),
                    enderecoEntity.getBairro(),
                    enderecoEntity.getLocalidade(),
                    enderecoEntity.getUf()
            );
        }

    public static Endereco toEnderecoResponse(EnderecoEntity endereco) {
        return new Endereco(
                endereco.getCep(),
                endereco.getRua(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getBairro(),
                endereco.getLocalidade(),
                endereco.getUf()
        );
    }
}
