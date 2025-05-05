package com.rodolfo.mongodbtest.converter;

import com.rodolfo.mongodbtest.dto.UsuarioResponseDTO;
import com.rodolfo.mongodbtest.entity.EnderecoEntity;
import com.rodolfo.mongodbtest.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "id", source = "usuario.id")
    @Mapping(target = "nome", source = "usuario.nome")
    @Mapping(target = "documento", source = "usuario.documento")
    @Mapping(target = "endereco", source = "enderecoEntity")
    UsuarioResponseDTO paraUsuarioResponseDTO(UsuarioEntity usuario, EnderecoEntity enderecoEntity);
}