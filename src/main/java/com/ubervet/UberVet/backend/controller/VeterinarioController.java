package com.ubervet.UberVet.backend.controller;

import com.ubervet.UberVet.backend.model.Veterinario;
import com.ubervet.UberVet.backend.service.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/veterinarios")
public class VeterinarioController {

    @Autowired
    private VeterinarioService veterinarioService;

    @PostMapping
    public ResponseEntity<Veterinario> criarVeterinario(@RequestBody Veterinario veterinario) {
        Veterinario responseVeterinario = veterinarioService.criarVeterinario(veterinario);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseVeterinario);
    }

    @GetMapping
    public ResponseEntity<List<Veterinario>> listarTodosVeterinarios() {
        List<Veterinario> responseVeterinario = veterinarioService.listarTodosVeterinarios();
        return ResponseEntity.status(HttpStatus.OK).body(responseVeterinario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Veterinario>> listarVeterinarioPorId(@PathVariable("id") Integer id) {
        Optional<Veterinario> responseVeterinario = veterinarioService.listarVeterinarioPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseVeterinario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVeterinarioPorId(@PathVariable("id") Integer id) {
        veterinarioService.deletarVeterinarioPorId(id);
        return ResponseEntity.status(HttpStatus.GONE).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veterinario> atualizarVeterinario(@PathVariable("id") Integer id,
                                                            @RequestBody Veterinario veterinario) {
        Veterinario responseVeterinario = veterinarioService.atualizarVeterinario(id, veterinario);
        return ResponseEntity.status(HttpStatus.OK).body(responseVeterinario);
    }

}
