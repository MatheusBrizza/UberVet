package com.ubervet.backend.controller;

import com.ubervet.backend.dto.UsuarioRequestDTO;
import com.ubervet.backend.model.Veterinario;
import com.ubervet.backend.service.VeterinarioService;
import com.ubervet.backend.service.exception.ListaVaziaException;
import com.ubervet.backend.service.exception.VeterinarioExistenteException;
import com.ubervet.backend.service.exception.VeterinarioNaoExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/veterinarios")
public class VeterinarioController {

    @Autowired
    private VeterinarioService veterinarioService;

    @PostMapping
    public ResponseEntity<Veterinario> criarVeterinario(@RequestBody Veterinario veterinario)
            throws VeterinarioExistenteException {
        Veterinario responseVeterinario = veterinarioService.criarVeterinario(veterinario);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseVeterinario);
    }

    @GetMapping
    public ResponseEntity<List<Veterinario>> listarTodosVeterinarios() throws ListaVaziaException {
        List<Veterinario> responseVeterinario = veterinarioService.listarTodosVeterinarios();
        return ResponseEntity.status(HttpStatus.OK).body(responseVeterinario);
    }

    @DeleteMapping("/email/{email}")
    public ResponseEntity<Void> deletarVeterinairoPorEmail(@PathVariable("email") String email)
            throws VeterinarioNaoExistenteException {
        veterinarioService.deletarVeterinarioPorEmail(email);
        return ResponseEntity.status(HttpStatus.GONE).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veterinario> atualizarVeterinario(@PathVariable("id") String id,
                                                            @RequestBody Veterinario veterinario)
            throws VeterinarioNaoExistenteException {
        Veterinario responseVeterinario = veterinarioService.atualizarVeterinario(id, veterinario);
        return ResponseEntity.status(HttpStatus.OK).body(responseVeterinario);
    }
}
