package com.rodolfo.mongodbtest.dto;

import com.rodolfo.mongodbtest.entity.EnderecoEntity;
import org.bson.types.ObjectId;

public record EnderecoRequestDTO(
        String rua,

        Long numero,

        String bairro,

        String complemento,

        String cidade,

        String cep) {

    public static EnderecoEntity toEnderecoEntity(EnderecoRequestDTO enderecoDTO, ObjectId usuarioId) {
        return EnderecoEntity.builder()
                .rua(enderecoDTO.rua())
                .bairro(enderecoDTO.bairro())
                .usuarioId(usuarioId)
                .cep(enderecoDTO.cep())
                .cidade(enderecoDTO.cidade())
                .numero(enderecoDTO.numero())
                .complemento(enderecoDTO.complemento())
                .build();
    }
}