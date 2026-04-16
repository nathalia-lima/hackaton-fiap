package com.hackaton.fiap.infra.repository;

import com.hackaton.fiap.infra.entity.UnidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepository extends JpaRepository<UnidadeEntity, Long> {
}
