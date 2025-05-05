package com.rodolfo.mongodbtest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rodolfo.mongodbtest.entity.UsuarioEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public record UsuarioRequestDTO(
        String nome,

        @JsonProperty(required = true)
        String email,

        String documento,

        EnderecoRequestDTO endereco) {

    public static UsuarioEntity toUsuarioEntity(UsuarioRequestDTO usuarioDTO) {
        return UsuarioEntity.builder()
                .id(UUID.randomUUID().toString())
                .nome(usuarioDTO.nome())
                .documento(usuarioDTO.documento())
                .email(usuarioDTO.email())
                .dataCadastro(LocalDateTime.now())
                .build();

    }
}