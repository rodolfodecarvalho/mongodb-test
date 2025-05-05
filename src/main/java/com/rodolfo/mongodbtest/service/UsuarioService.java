package com.rodolfo.mongodbtest.service;


import com.rodolfo.mongodbtest.dto.EnderecoRequestDTO;
import com.rodolfo.mongodbtest.dto.UsuarioRequestDTO;
import com.rodolfo.mongodbtest.dto.UsuarioResponseDTO;
import com.rodolfo.mongodbtest.entity.EnderecoEntity;
import com.rodolfo.mongodbtest.entity.UsuarioEntity;
import com.rodolfo.mongodbtest.exceptions.BusinessException;
import com.rodolfo.mongodbtest.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.util.Assert.notNull;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final EnderecoService enderecoService;


    public UsuarioEntity salvaUsuario(UsuarioEntity usuarioEntity) {
        return usuarioRepository.save(usuarioEntity);
    }

    public UsuarioResponseDTO gravarUsuarios(UsuarioRequestDTO usuarioRequestDTO) {
        try {
            notNull(usuarioRequestDTO, "Os dados do usuário são obrigatórios");
            UsuarioEntity usuarioEntity = salvaUsuario(UsuarioRequestDTO.toUsuarioEntity(usuarioRequestDTO));
            EnderecoEntity enderecoEntity = enderecoService.salvaEndereco(
                    EnderecoRequestDTO.toEnderecoEntity(usuarioRequestDTO.endereco(), usuarioEntity.getId()));
            return new UsuarioResponseDTO(usuarioEntity, enderecoEntity);
        } catch (Exception e) {
            throw new BusinessException("Erro ao gravar dados de usuário", e);
        }
    }


    public UsuarioResponseDTO buscaDadosUsuario(String email) {
        try {
            UsuarioEntity entity = usuarioRepository.findByEmail(email);
            notNull(entity, "Usuário não encontrado");
            EnderecoEntity enderecoEntity = enderecoService.findByUsuarioId(entity.getId());

            return new UsuarioResponseDTO(entity, enderecoEntity);
        } catch (Exception e) {
            throw new BusinessException("Erro ao buscar dados de usuário", e);
        }
    }

    @Transactional
    public void deletaDadosUsuario(String email) {
        UsuarioEntity entity = usuarioRepository.findByEmail(email);
        usuarioRepository.deleteByEmail(email);
        enderecoService.deleteByUsuarioId(entity.getId());
    }
}