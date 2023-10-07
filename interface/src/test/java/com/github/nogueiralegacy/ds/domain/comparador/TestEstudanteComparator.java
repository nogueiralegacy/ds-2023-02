package com.github.nogueiralegacy.ds.domain.comparador;

import com.github.nogueiralegacy.ds.domain.Estudante;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestEstudanteComparator {
    List<Estudante> estudantes = SetUp.getEstudantes();

    @Test
    void testEstudantePorIdadeComparator() {
        estudantes.sort(new EstudantePorIdadeComparator());
        assertEquals(18, estudantes.get(0).getIdade());
        assertEquals(23, estudantes.get(estudantes.size() - 1).getIdade());
    }

    @Test
    void testEstudantePorPrimeiroNomeComparator() {
        estudantes.sort(new EstudantePorPrimeiroNomeComparator());
        assertEquals("Ana", estudantes.get(0).getNomeCompleto().split(" ")[0]);
        assertEquals("Thiago", estudantes.get(estudantes.size() - 1).getNomeCompleto().split(" ")[0]);
    }

    @Test
    void testEstudantePorSobrenomeComparator() {
        estudantes.sort(new EstudantePorSobrenomeomeComparator());
        assertEquals("Abravanel", estudantes.get(0).getNomeCompleto().split(" ")[1]);
        assertEquals("Torres", estudantes.get(estudantes.size() - 1).getNomeCompleto().split(" ")[1]);
    }
}
