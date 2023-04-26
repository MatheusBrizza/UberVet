package com.ubervet.UberVet.service;

import com.ubervet.UberVet.model.Tutor;
import com.ubervet.UberVet.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    public Tutor criarTutor(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public List<Tutor> listarTodosTutores() {
        return tutorRepository.findAll();
    }

    public Optional<Tutor> listarTutorPorId(Integer id) {
        return tutorRepository.findById(id);
    }

    public void deletarTutorPorId(Integer id) {
        tutorRepository.deleteById(id);
    }

    public Tutor atualizarTutor(Integer id, Tutor tutorNovo) {
        Optional<Tutor> tutorAntigo = tutorRepository.findById(id);
        tutorNovo.setId(tutorAntigo.get().getId());
        return tutorRepository.save(tutorNovo);
    }

}
