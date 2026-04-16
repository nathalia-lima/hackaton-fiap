package com.hackaton.fiap.core.usecase.medicamento;

import com.hackaton.fiap.api.dto.medicamento.MedicamentoRequest;
import com.hackaton.fiap.api.mappers.MedicamentoMappers;
import com.hackaton.fiap.api.mappers.UnidadeMappers;
import com.hackaton.fiap.core.domains.Medicamento;
import com.hackaton.fiap.infra.entity.MedicamentoEntity;
import com.hackaton.fiap.infra.entity.UnidadeEntity;
import com.hackaton.fiap.infra.repository.MedicamentoRepository;
import com.hackaton.fiap.infra.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

@Service
public class CriarMedicamento {
    private final MedicamentoRepository medicamentoRepository;
    private final MedicamentoMappers medicamentoMappers;
    private final UnidadeMappers unidadeMappers;
    private final UnidadeRepository unidadeRepository;

    public CriarMedicamento(MedicamentoRepository medicamentoRepository, MedicamentoMappers medicamentoMappers, UnidadeMappers unidadeMappers, UnidadeRepository unidadeRepository) {
        this.medicamentoRepository = medicamentoRepository;
        this.medicamentoMappers = medicamentoMappers;
        this.unidadeMappers = unidadeMappers;
        this.unidadeRepository = unidadeRepository;
    }

    public void executar(Long unidadeId, MedicamentoRequest medicamento) {
        UnidadeEntity unidade = unidadeRepository.findById(unidadeId)
                .orElseThrow(() -> new RuntimeException("Unidade não encontrada"));

        MedicamentoEntity medicamentoSave = medicamentoMappers.toMedicamentoEntity(medicamento);

        medicamentoSave.setUnidade(unidade);

        medicamentoRepository.save(medicamentoSave);
    }
}
