package com.rodolfo.mongodbtest.repository;

import com.rodolfo.mongodbtest.entity.UsuarioEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<UsuarioEntity, ObjectId> {

    Optional<UsuarioEntity> findFirstByEmail(String email);
}