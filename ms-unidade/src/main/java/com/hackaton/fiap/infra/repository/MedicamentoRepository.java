package com.hackaton.fiap.infra.repository;

import com.hackaton.fiap.core.domains.Status;
import com.hackaton.fiap.infra.entity.MedicamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicamentoRepository extends JpaRepository<MedicamentoEntity, Long> {
    List<MedicamentoEntity> findByNomeContainingIgnoreCaseAndStatus(String nome, Status status);
}
