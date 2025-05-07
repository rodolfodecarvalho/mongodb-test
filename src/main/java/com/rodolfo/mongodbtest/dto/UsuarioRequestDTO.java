package com.rodolfo.mongodbtest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rodolfo.mongodbtest.entity.UsuarioEntity;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record UsuarioRequestDTO(
        @NotBlank(message = "id must not be null") String nome,

        @JsonProperty(required = true)
        String email,

        String documento,

        EnderecoRequestDTO endereco) {

    public static UsuarioEntity toUsuarioEntity(UsuarioRequestDTO usuarioDTO) {
        return UsuarioEntity.builder()
                .nome(usuarioDTO.nome())
                .documento(usuarioDTO.documento())
                .email(usuarioDTO.email())
                .dataCadastro(LocalDateTime.now())
                .build();
    }
}