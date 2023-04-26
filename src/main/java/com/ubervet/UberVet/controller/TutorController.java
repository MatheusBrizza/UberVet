package com.ubervet.UberVet.controller;

import com.ubervet.UberVet.model.Tutor;
import com.ubervet.UberVet.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/tutores")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @PostMapping
    public ResponseEntity<Tutor> criarTutor(@RequestBody Tutor tutor) {
        Tutor responseTutor = tutorService.criarTutor(tutor);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseTutor);
    }

    @GetMapping
    public ResponseEntity<List<Tutor>> buscarTodosTutores() {
        List<Tutor> responseTutor = tutorService.listarTodosTutores();
        return ResponseEntity.status(HttpStatus.OK).body(responseTutor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Tutor>> buscarTutorPorId(@PathVariable("id") Integer id) {
        Optional<Tutor> responseTutor = tutorService.listarTutorPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseTutor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTutorPorId(@PathVariable("id") Integer id) {
        tutorService.deletarTutorPorId(id);
        return ResponseEntity.status(HttpStatus.GONE).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutor> atualizarTutor(@PathVariable("id") Integer id,
                                                @RequestBody Tutor tutor) {
        Tutor responseTutor = tutorService.atualizarTutor(id, tutor);
        return ResponseEntity.status(HttpStatus.OK).body(responseTutor);
    }

}
