package com.hackaton.fiap.infra.entity;

import com.hackaton.fiap.core.domains.Endereco;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "unidade")
public class UnidadeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private EnderecoEntity endereco;
    @OneToMany(mappedBy = "unidade", cascade = CascadeType.ALL)
    private List<MedicamentoEntity> medicamento;

    public UnidadeEntity() {
    }

    public UnidadeEntity(String nome, String email, String senha, String telefone, EnderecoEntity endereco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public UnidadeEntity(Long id, String nome, String email, String senha, String telefone, EnderecoEntity endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.endereco = endereco;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }

    public List<MedicamentoEntity> getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(List<MedicamentoEntity> medicamento) {
        this.medicamento = medicamento;
    }
}
