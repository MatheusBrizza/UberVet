package com.ubervet.UberVet.backend.service;

import com.ubervet.UberVet.backend.model.Veterinario;
import com.ubervet.UberVet.backend.repository.VeterinarioRepository;
import com.ubervet.UberVet.backend.service.exception.ListaVaziaException;
import com.ubervet.UberVet.backend.service.exception.VeterinarioExistenteException;
import com.ubervet.UberVet.backend.service.exception.VeterinarioNaoExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.List;
import java.util.Optional;

@Service
public class VeterinarioService {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public Veterinario criarVeterinario(Veterinario veterinario) {
        validarVeterinarioExistentePorId(veterinario.getId());
        veterinario = Veterinario.builder()
                .id(veterinario.getId())
                .nome(veterinario.getNome())
                .email(veterinario.getEmail())
                .build();
        return veterinarioRepository.save(veterinario);
    }


    public List<Veterinario> listarTodosVeterinarios() {
        validarListaVazia();
        return veterinarioRepository.findAll();
    }

    public Optional<Veterinario> listarVeterinarioPorId(Integer id) {
        validarVeterinarioNaoExistentePorId(id);
        return veterinarioRepository.findById(id);
    }

    public Veterinario listarVeterinarioPorNome(String nome) {
        validarVeterinarioNaoExistentePorNome(nome);
        return veterinarioRepository.findByNome(nome);
    }

    public void deletarVeterinarioPorId(Integer id) {
        validarVeterinarioNaoExistentePorId(id);
        veterinarioRepository.deleteById(id);
    }

    public Veterinario atualizarVeterinario(Integer id, Veterinario veterinarioNovo) {
        validarVeterinarioExistentePorId(id);
        Optional<Veterinario> veterinarioAntigo = listarVeterinarioPorId(id);
        veterinarioNovo.setId(veterinarioAntigo.get().getId());
        return veterinarioRepository.save(veterinarioNovo);
    }

    private void validarVeterinarioNaoExistentePorId(Integer id) throws VeterinarioNaoExistenteException {
        Optional<Veterinario> veterinarioExists = listarVeterinarioPorId(id);

        if (veterinarioExists.isEmpty()) {
            throw new VeterinarioNaoExistenteException(
                    HttpStatus.BAD_REQUEST,
                    String.format("Não existe um veterinário com id %s, é preciso criar antes de completar esta ação.", id)
            );
        }
    }

    private void validarVeterinarioExistentePorId(Integer id) throws VeterinarioExistenteException {
        Optional<Veterinario> veterinarioExists = veterinarioRepository.findById(id);

        if (!veterinarioExists.isEmpty()) {
            throw new VeterinarioExistenteException(
                    HttpStatus.BAD_REQUEST,
                    String.format("Usuario com id %s já existe.", id)
            );
        }
    }

    private void validarVeterinarioNaoExistentePorNome(String nome) throws VeterinarioNaoExistenteException {
        Veterinario veterinario = veterinarioRepository.findByNome(nome);

        if(veterinario == null) {
            throw new VeterinarioNaoExistenteException(
                    HttpStatus.BAD_REQUEST,
                    String.format("Não existe um veterinário de nome %s, é preciso criar antes de completar esta ação.", nome)
            );
        }
    }

    private void validarListaVazia() throws ListaVaziaException {
        List<Veterinario> listaExiste = veterinarioRepository.findAll();
        if(listaExiste.isEmpty()) {
            throw new ListaVaziaException(
                    HttpStatus.NO_CONTENT,
                    String.format("Lista vazia")
            );
        }
    }

}
