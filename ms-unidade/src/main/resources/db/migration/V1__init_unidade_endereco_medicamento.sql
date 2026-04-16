-- V1: cria tabelas endereco, unidade e medicamento

CREATE TABLE IF NOT EXISTS endereco (
  id BIGSERIAL PRIMARY KEY,
  cep VARCHAR(20),
  rua VARCHAR(255),
  numero VARCHAR(50),
  complemento VARCHAR(255),
  bairro VARCHAR(255),
  localidade VARCHAR(255),
  uf VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS unidade (
  id BIGSERIAL PRIMARY KEY,
  nome VARCHAR(255) NOT NULL,
  email VARCHAR(255),
  senha VARCHAR(255),
  telefone VARCHAR(50),
  endereco_id BIGINT,
  CONSTRAINT fk_unidade_endereco FOREIGN KEY (endereco_id) REFERENCES endereco(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS medicamento (
  id BIGSERIAL PRIMARY KEY,
  id_unidade BIGINT,
  nome VARCHAR(255),
  status VARCHAR(20),
  CONSTRAINT fk_medicamento_unidade FOREIGN KEY (id_unidade) REFERENCES unidade(id) ON DELETE CASCADE,
  CONSTRAINT chk_status_medicamento CHECK (status IN ('DISPONIVEL', 'INDISPONIVEL'))
);

CREATE INDEX IF NOT EXISTS idx_unidade_endereco_id ON unidade(endereco_id);
CREATE INDEX IF NOT EXISTS idx_medicamento_unidade_id ON medicamento(id_unidade);