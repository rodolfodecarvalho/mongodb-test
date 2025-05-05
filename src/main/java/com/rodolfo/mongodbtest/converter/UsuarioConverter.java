package com.rodolfo.mongodbtest.converter;

import com.rodolfo.mongodbtest.dto.EnderecoRequestDTO;
import com.rodolfo.mongodbtest.dto.UsuarioRequestDTO;
import com.rodolfo.mongodbtest.entity.EnderecoEntity;
import com.rodolfo.mongodbtest.entity.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UsuarioConverter {

    public UsuarioEntity paraUsuarioEntity(UsuarioRequestDTO usuarioDTO) {
        return UsuarioEntity.builder()
                .id(UUID.randomUUID().toString())
                .nome(usuarioDTO.nome())
                .documento(usuarioDTO.documento())
                .email(usuarioDTO.email())
                .dataCadastro(LocalDateTime.now())
                .build();

    }


    public EnderecoEntity paraEnderecoEntity(EnderecoRequestDTO enderecoDTO, String usuarioId) {
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