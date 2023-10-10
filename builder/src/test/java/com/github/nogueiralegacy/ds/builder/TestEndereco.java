package com.github.nogueiralegacy.ds.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestEndereco {
    @Test
    void TestBuilder() {
        Endereco endereco1 = new Endereco("Rua canoa", "Bueno", "74169101", "24", "Goiânia", "Goiás", null, null, "Na frente do pé de jabuticaba");

        Endereco endereco2 = Endereco.builder().rua("Rua canoa").setor("Bueno").CEP("74169101").numero("24").cidade("Goiânia").estado("Goiás").complemento("Na frente do pé de jabuticaba").build();

        assertEquals(endereco1, endereco2);
    }
}
