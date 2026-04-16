package com.hackaton.fiap.api.dto;

import com.hackaton.fiap.grpc.ConsultaRequest;
import com.hackaton.fiap.grpc.ConsultaResponse;
import com.hackaton.fiap.grpc.EstoqueServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class BuscaMedicamento{

    @GrpcClient("inventory-service")
    private EstoqueServiceGrpc.EstoqueServiceBlockingStub estoqueStub;

    public String buscarRemedio(String nome) {
        ConsultaRequest request = ConsultaRequest.newBuilder()
                .setNomeMedicamento(nome)
                .build();

        try {
            ConsultaResponse response = estoqueStub.consultarDisponibilidade(request);

            if (response.getDisponivel()) {
                return "Medicamento encontrado na unidade: " + response.getNomeUnidade() +
                        "/n Endereço: " + response.getEnderecoUnidade();
            } else {
                return "Medicamento não disponível em nenhuma unidade próxima.";
            }
        } catch (Exception e) {
            return "Erro ao consultar o serviço de estoque: " + e.getMessage();
        }
    }
}