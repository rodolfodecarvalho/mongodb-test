package com.rodolfo.mongodbtest.dto;

public record EnderecoResponseDTO(
        String rua,

        Long numero,

        String bairro,

        String complemento,

        String cidade,

        String cep) {

}