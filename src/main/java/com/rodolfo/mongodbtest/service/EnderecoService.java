package com.rodolfo.mongodbtest.service;

import com.rodolfo.mongodbtest.entity.EnderecoEntity;
import com.rodolfo.mongodbtest.entity.UsuarioEntity;
import com.rodolfo.mongodbtest.exceptions.RecordNotFoundException;
import com.rodolfo.mongodbtest.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository repository;


    public EnderecoEntity save(EnderecoEntity enderecoEntity) {
        return repository.save(enderecoEntity);
    }

    public EnderecoEntity findByUsuarioId(ObjectId usuarioId) {
        return repository.findFirstByUsuarioId(usuarioId).orElseThrow(() -> new RecordNotFoundException(usuarioId));
    }

    public void deleteByUsuario(UsuarioEntity usuarioEntity) {
        repository.delete(repository.findFirstByUsuarioId(usuarioEntity.getId()).orElseThrow(() -> new RecordNotFoundException(usuarioEntity.getId())));
    }
}