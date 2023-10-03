package com.github.nogueiralegacy.ds.newton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraTest {
    @Test
    void raizQuadradaTest() {
        double numero = 25;
        double precisao = Math.pow(10, -5);

        assertEquals(5, Calculadora.aproximacaoDeNewton(numero, precisao));
    }
}
