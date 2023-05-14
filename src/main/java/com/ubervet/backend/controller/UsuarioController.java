package com.ubervet.backend.controller;

import com.ubervet.backend.dto.UsuarioRequestDTO;
import com.ubervet.backend.model.Usuario;
import com.ubervet.backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        Boolean responseUsuario = usuarioService.login(usuarioRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(responseUsuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        Usuario responseUsuario = usuarioService.criarAdmin(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseUsuario);
    }

}
