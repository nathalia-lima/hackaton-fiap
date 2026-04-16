package com.hackaton.fiap.infra.entity;

import com.hackaton.fiap.core.domains.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "medicamento")
public class MedicamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_unidade", referencedColumnName = "id")
    private UnidadeEntity unidade;
    private String nome;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "status_enum")
    private Status status;

    public MedicamentoEntity(Long id, UnidadeEntity unidade, String nome, Status status) {
        this.id = id;
        this.unidade = unidade;
        this.nome = nome;
        this.status = status;
    }

    public MedicamentoEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UnidadeEntity getUnidade() {
        return unidade;
    }

    public void setUnidade(UnidadeEntity unidade) {
        this.unidade = unidade;
    }
}
