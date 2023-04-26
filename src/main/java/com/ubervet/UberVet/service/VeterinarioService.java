package com.ubervet.UberVet.service;

import com.ubervet.UberVet.model.Veterinario;
import com.ubervet.UberVet.repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarioService {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public Veterinario criarVeterinario(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }

    public List<Veterinario> listarTodosVeterinarios() {
        return veterinarioRepository.findAll();
    }

    public Optional<Veterinario> listarVeterinarioPorId(Integer id) {
        return veterinarioRepository.findById(id);
    }

    public void deletarVeterinarioPorId(Integer id) {
        veterinarioRepository.deleteById(id);
    }

    public Veterinario atualizarVeterinario(Integer id, Veterinario veterinarioNovo) {
        Optional<Veterinario> veterinarioAntigo = veterinarioRepository.findById(id);
        veterinarioNovo.setId(veterinarioAntigo.get().getId());
        return veterinarioRepository.save(veterinarioNovo);
    }

}
