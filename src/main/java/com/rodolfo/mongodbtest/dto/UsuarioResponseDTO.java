package com.rodolfo.mongodbtest.dto;

import com.rodolfo.mongodbtest.entity.EnderecoEntity;
import com.rodolfo.mongodbtest.entity.UsuarioEntity;
import org.bson.types.ObjectId;

public record UsuarioResponseDTO(
        ObjectId id,

        String nome,

        String email,

        String documento,

        EnderecoResponseDTO endereco) {

    public UsuarioResponseDTO(UsuarioEntity usuario, EnderecoEntity endereco) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getDocumento(),
                new EnderecoResponseDTO(endereco.getRua(), endereco.getNumero(), endereco.getBairro(), endereco.getComplemento(), endereco.getCidade(), endereco.getCep())
        );
    }
}