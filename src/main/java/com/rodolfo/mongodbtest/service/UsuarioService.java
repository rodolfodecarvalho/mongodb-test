package com.rodolfo.mongodbtest.service;


import com.rodolfo.mongodbtest.dto.UsuarioRequestDTO;
import com.rodolfo.mongodbtest.dto.UsuarioResponseDTO;
import com.rodolfo.mongodbtest.entity.EnderecoEntity;
import com.rodolfo.mongodbtest.entity.UsuarioEntity;
import com.rodolfo.mongodbtest.exceptions.RecordNotFoundException;
import com.rodolfo.mongodbtest.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.rodolfo.mongodbtest.dto.EnderecoRequestDTO.toEnderecoEntity;
import static com.rodolfo.mongodbtest.dto.UsuarioRequestDTO.toUsuarioEntity;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final EnderecoService enderecoService;

    public UsuarioResponseDTO save(UsuarioRequestDTO usuarioRequestDTO) {
        UsuarioEntity usuarioEntity = repository.save(toUsuarioEntity(usuarioRequestDTO));

        EnderecoEntity enderecoEntity = enderecoService.save(
                toEnderecoEntity(usuarioRequestDTO.endereco(), usuarioEntity.getId()));

        return new UsuarioResponseDTO(usuarioEntity, enderecoEntity);
    }

    public UsuarioResponseDTO getByEmail(String email) {
        UsuarioEntity entity = repository.findFirstByEmail(email).orElseThrow(() -> new RecordNotFoundException(email));
        EnderecoEntity enderecoEntity = enderecoService.findByUsuarioId(entity.getId());

        return new UsuarioResponseDTO(entity, enderecoEntity);
    }

    @Transactional
    public void deleteUsuarioByEmail(String email) {
        UsuarioEntity entity = repository.findFirstByEmail(email).orElseThrow(() -> new RecordNotFoundException(email));
        repository.delete(entity);
        enderecoService.deleteByUsuario(entity);
    }
}