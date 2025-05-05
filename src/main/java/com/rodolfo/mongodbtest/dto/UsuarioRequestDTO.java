package com.rodolfo.mongodbtest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UsuarioRequestDTO(
        String nome,

        @JsonProperty(required = true)
        String email,

        String documento,

        EnderecoRequestDTO endereco) {
}