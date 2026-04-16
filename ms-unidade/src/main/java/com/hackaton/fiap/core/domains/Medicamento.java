package com.hackaton.fiap.core.domains;

public class Medicamento {
    Long id;
    Unidade unidade;
    String nome;
    Status status;

    public Medicamento(Long id, Unidade unidade, String nome, Status status) {
        this.id = id;
        this.unidade = unidade;
        this.nome = nome;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
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
}
