package com.ubervet.backend.service;

import com.ubervet.backend.dto.UsuarioRequestDTO;
import com.ubervet.backend.model.Usuario;
import com.ubervet.backend.model.UsuarioComparator;
import com.ubervet.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Boolean login(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = usuarioRepository.findByEmail(usuarioRequestDTO.getEmail());
        if (usuario != null) {
            if (usuario.getSenha().equals(usuarioRequestDTO.getSenha())) {
                return true;
            }
        }
        return false;
    }

    public Usuario criarAdmin(Usuario usuario) {
        usuario = Usuario.builder()
                .id(criarId())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .build();
        return usuarioRepository.save(usuario);
    }

    private String criarId() {
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        if (listaUsuarios.isEmpty()) {
            return "1";
        }
        Collections.sort(listaUsuarios, new UsuarioComparator());
        Integer lastId = listaUsuarios.size() + 1;
        return lastId.toString();
    }
}
