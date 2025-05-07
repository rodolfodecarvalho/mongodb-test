package com.rodolfo.mongodbtest.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Document(collection = "usuario")
@TypeAlias(value = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioEntity {

    @MongoId()
    private ObjectId id;

    private String nome;

    @Indexed(unique = true)
    private String email;

    @Indexed(unique = true)
    private String documento;

    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;
}