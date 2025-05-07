package com.rodolfo.mongodbtest.controller;

import com.rodolfo.mongodbtest.dto.UsuarioRequestDTO;
import com.rodolfo.mongodbtest.dto.UsuarioResponseDTO;
import com.rodolfo.mongodbtest.service.UsuarioService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping()
    public ResponseEntity<UsuarioResponseDTO> save(@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return ResponseEntity.ok(usuarioService.save(usuarioRequestDTO));
    }


    @GetMapping()
    public ResponseEntity<UsuarioResponseDTO> getByEmail(@RequestParam("email") @Email(message = "Email inválido") String email) {
        return ResponseEntity.ok(usuarioService.getByEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUsuario(@RequestParam("email") @Email(message = "Email inválido") String email) {
        usuarioService.deleteUsuarioByEmail(email);
        return ResponseEntity.noContent().build();
    }
}