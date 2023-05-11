package com.ubervet.backend.service;

import com.ubervet.backend.dto.VeterinarioRequestDTO;
import com.ubervet.backend.model.Veterinario;
import com.ubervet.backend.repository.VeterinarioRepository;
import com.ubervet.backend.service.exception.ListaVaziaException;
import com.ubervet.backend.service.exception.VeterinarioExistenteException;
import com.ubervet.backend.service.exception.VeterinarioNaoExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarioService {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public Veterinario criarVeterinario(Veterinario veterinario) throws VeterinarioExistenteException {
        Integer.parseInt(veterinario.getId());
        validarVeterinarioExistentePorId(veterinario.getId());
        veterinario = Veterinario.builder()
                .id(veterinario.getId())
                .nome(veterinario.getNome())
                .registro(veterinario.getRegistro())
                .especializacao(veterinario.getEspecializacao())
                .endereco(veterinario.getEndereco())
                .telefone(veterinario.getTelefone())
                .email(veterinario.getEmail())
                .senha(veterinario.getSenha())
                .build();
        return veterinarioRepository.save(veterinario);
    }


    public List<Veterinario> listarTodosVeterinarios() throws ListaVaziaException {
        validarListaVazia();
        return veterinarioRepository.findAll();
    }

    public Optional<Veterinario> listarVeterinarioPorId(Integer id)
            throws VeterinarioNaoExistenteException {
        validarVeterinarioNaoExistentePorId(id);
        return veterinarioRepository.findById(id);
    }

    public Veterinario listarVeterinarioPorEmail(String email) throws VeterinarioNaoExistenteException {
        validarVeterinarioNaoExistentePorEmail(email);
        return veterinarioRepository.findByEmail(email);
    }

    public void deletarVeterinarioPorId(Integer id) throws VeterinarioNaoExistenteException {
        validarVeterinarioNaoExistentePorId(id);
        veterinarioRepository.deleteById(id);
    }

    public void deletarVeterinarioPorEmail(String email) throws VeterinarioNaoExistenteException {
        validarVeterinarioNaoExistentePorEmail(email);
        veterinarioRepository.deleteByEmail(email);
    }

    public Veterinario atualizarVeterinario(Integer id, Veterinario veterinarioNovo)
            throws VeterinarioNaoExistenteException {
        Optional<Veterinario> veterinarioAntigo = listarVeterinarioPorId(id);
        veterinarioNovo.setId(veterinarioAntigo.get().getId());
        return veterinarioRepository.save(veterinarioNovo);
    }

    public Boolean login(VeterinarioRequestDTO veterinarioRequestDTO) {
        Veterinario veterinario = veterinarioRepository.findByEmail(veterinarioRequestDTO.getEmail());
        if (veterinario != null) {
            if (veterinario.getSenha().equals(veterinarioRequestDTO.getSenha())) {
                return true;
            }
        }
        return false;
    }

    private void validarVeterinarioNaoExistentePorId(Integer id)
            throws VeterinarioNaoExistenteException {
        Optional<Veterinario> veterinarioExists = veterinarioRepository.findById(id);

        if (veterinarioExists.isEmpty()) {
            throw new VeterinarioNaoExistenteException(
                    String.format("Não existe um veterinário com id %s, é preciso criar antes de " +
                            "completar esta ação.", id)
            );
        }
    }

    private void validarVeterinarioExistentePorId(String id) throws VeterinarioExistenteException {
        Optional<Veterinario> veterinarioExists = Optional.ofNullable(veterinarioRepository.findById(id));

        if (veterinarioExists.isPresent()) {
            throw new VeterinarioExistenteException(
                    String.format("Usuario com id %s já existe.", id)
            );
        }
    }

    private void validarVeterinarioNaoExistentePorEmail(String email)
            throws VeterinarioNaoExistenteException {
        Veterinario veterinario = veterinarioRepository.findByEmail(email);

        if (veterinario == null) {
            throw new VeterinarioNaoExistenteException(
                    String.format("Não existe um veterinário com email %s, é preciso criar antes de " +
                            "completar esta ação.", email)
            );
        }
    }

    private void validarListaVazia() throws ListaVaziaException {
        List<Veterinario> listaExiste = veterinarioRepository.findAll();
        if (listaExiste.isEmpty()) {
            throw new ListaVaziaException(
                    String.format("Lista vazia")
            );
        }
    }

}
