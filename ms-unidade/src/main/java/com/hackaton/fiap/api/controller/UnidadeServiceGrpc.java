package com.hackaton.fiap.api.controller;

import com.hackaton.fiap.core.domains.Status;
import com.hackaton.fiap.infra.repository.MedicamentoRepository;
import com.hackaton.fiap.grpc.ConsultaRequest;
import com.hackaton.fiap.grpc.EstoqueServiceGrpc;
import com.hackaton.fiap.grpc.ConsultaResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UnidadeServiceGrpc extends EstoqueServiceGrpc.EstoqueServiceImplBase {
    private final MedicamentoRepository repository;

    public UnidadeServiceGrpc(MedicamentoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void consultarDisponibilidade(ConsultaRequest request,
                                         StreamObserver<ConsultaResponse> responseObserver) {

        var medicamentos = repository.findByNomeContainingIgnoreCaseAndStatus(
                request.getNomeMedicamento(),
                Status.DISPONIVEL
        );

        ConsultaResponse.Builder responseBuilder = ConsultaResponse.newBuilder();

        if (!medicamentos.isEmpty()) {
            var med = medicamentos.get(0);

            responseBuilder
                    .setDisponivel(true)
                    .setNomeMedicamento(med.getNome())
                    .setNomeUnidade(med.getUnidade().getNome())
                    .setEnderecoUnidade(med.getUnidade().getEndereco().getRua() + ", " + med.getUnidade().getEndereco().getNumero());
        } else {
            responseBuilder
                    .setDisponivel(false)
                    .setNomeMedicamento(request.getNomeMedicamento());
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }
}
