package com.rodolfo.mongodbtest.dto;

public record EnderecoRequestDTO(
        String rua,

        Long numero,

        String bairro,

        String complemento,

        String cidade,

        String cep) {
}