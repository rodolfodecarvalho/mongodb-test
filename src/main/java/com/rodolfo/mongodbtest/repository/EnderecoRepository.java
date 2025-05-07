package com.rodolfo.mongodbtest.repository;

import com.rodolfo.mongodbtest.entity.EnderecoEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EnderecoRepository extends MongoRepository<EnderecoEntity, ObjectId> {

    Optional<EnderecoEntity> findFirstByUsuarioId(ObjectId usuarioId);
}