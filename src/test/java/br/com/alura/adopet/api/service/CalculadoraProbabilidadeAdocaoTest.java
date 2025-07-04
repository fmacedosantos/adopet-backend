package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.CadastroAbrigoDTO;
import br.com.alura.adopet.api.dto.CadastroPetDTO;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.ProbabilidadeAdocao;
import br.com.alura.adopet.api.model.TipoPet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraProbabilidadeAdocaoTest {

    // Método 1 para melhorar a legibilidade de testes
    @Test
    @DisplayName("Probabilidade alta para gatos jovens com peso baixo")
    void probabilidadeAltaCenario1() {
        // ARRANGE
        Abrigo abrigo = new Abrigo(new CadastroAbrigoDTO(
                "Abrigo feliz",
                "94999999999",
                "abrigofeliz@email.com.br"
        ));
        Pet pet = new Pet(new CadastroPetDTO(
                TipoPet.GATO,
                "Miau",
                "Siames",
                4,
                "Cinza",
                4.0f
        ), abrigo);
        CalculadoraProbabilidadeAdocao calculadora = new CalculadoraProbabilidadeAdocao();

        // ACT
        ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);

        // ASSERT
        assertEquals(ProbabilidadeAdocao.ALTA, probabilidade);
    }

    // Método 2 para melhorar a legibilidade de testes
    @Test
    void deveriaRetornarProbabilidadeMediaParaPetComIdadeAltaEPesoBaixo() {
        // ARRANGE
        Abrigo abrigo = new Abrigo(new CadastroAbrigoDTO(
                "Abrigo feliz",
                "94999999999",
                "abrigofeliz@email.com.br"
        ));
        Pet pet = new Pet(new CadastroPetDTO(
                TipoPet.GATO,
                "Miau",
                "Siames",
                15,
                "Cinza",
                4.0f
        ), abrigo);
        CalculadoraProbabilidadeAdocao calculadora = new CalculadoraProbabilidadeAdocao();

        // ACT
        ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);

        // ASSERT
        assertEquals(ProbabilidadeAdocao.MEDIA, probabilidade);
    }
}