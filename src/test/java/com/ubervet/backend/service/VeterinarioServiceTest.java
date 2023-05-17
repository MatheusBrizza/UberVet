package com.ubervet.backend.service;

import com.ubervet.backend.model.Veterinario;
import com.ubervet.backend.repository.VeterinarioRepository;
import com.ubervet.backend.service.exception.ListaVaziaException;
import com.ubervet.backend.service.exception.VeterinarioExistenteException;
import com.ubervet.backend.service.exception.VeterinarioNaoExistenteException;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(value = SpringRunner.class)
@SpringBootTest
public class VeterinarioServiceTest {

    @InjectMocks
    private VeterinarioService veterinarioService;

    @Mock
    private VeterinarioRepository veterinarioRepository;



    @Test
    @DisplayName("VeterinarioService salvarVeterinario Test")
    public void quandoSalvarVeterinario_deveRetornarSucesso() throws VeterinarioExistenteException {
        Veterinario lucas = new Veterinario("10", "lucas", "abc123", "otorrino",
                "rua abc, 123", "963258741", "luc@s.com", "asd");
        Veterinario lucas1 = new Veterinario("2", "2", "2", "2", "2", "2",
                "2", "2");

        Mockito.when(veterinarioRepository.save(Mockito.any(Veterinario.class))).thenReturn(lucas1);

        Veterinario vetSalvo = veterinarioService.criarVeterinario(lucas);

        Assert.assertEquals("2", vetSalvo.getNome());
    }

    @Test
    public void QuandoSalvarVeterinario_deveLancarException() throws VeterinarioExistenteException {
        Veterinario lucas = new Veterinario("10", "lucas", "abc123", "otorrino",
                "rua abc, 123", "963258741", "luc@s.com", "asd");
//        Mockito.when(veterinarioRepository.save(Mockito.any(Veterinario.class))).thenReturn(lucas);

        veterinarioService.criarVeterinario(lucas);
        Veterinario lucas2 = new Veterinario("10", "lucas", "abc123", "otorrino",
                "rua abc, 123", "963258741", "luc@s.com", "asd");
        veterinarioService.criarVeterinario(lucas2);
//        Assert.assertThrows("veterinario já existente", VeterinarioExistenteException,null);
    }

    @Test
    @DisplayName("VeterinarioService buscarTodosVeterinarios Test")
    public void quandoBuscarTodosVeterinario_deveRetornarTodosVeterinarios() throws ListaVaziaException {
        veterinarioService.listarTodosVeterinarios();
//        Assert.assertThrows();
    }

    @Test
    @DisplayName("VeterinarioService deletarVeterinarioPorEmail Test")
    public void passandoVeterinarioEmail_quandoDeletetarVeterinarioPorEmail_deveDeletarVeterinario()
            throws VeterinarioNaoExistenteException {
        Veterinario lucas = new Veterinario("10", "lucas", "abc123", "otorrino",
                "rua abc, 123", "963258741", "luc@s.com", "asd");

        veterinarioService.deletarVeterinarioPorEmail(lucas.getEmail());
//        Assert.assertEquals();
    }
}
