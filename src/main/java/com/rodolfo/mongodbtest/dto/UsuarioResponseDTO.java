package com.rodolfo.mongodbtest.dto;

public record UsuarioResponseDTO(
        String id,

        String nome,

        String email,

        String documento,

        EnderecoResponseDTO endereco) {


}