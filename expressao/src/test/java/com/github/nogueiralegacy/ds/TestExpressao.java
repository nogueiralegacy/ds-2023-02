package com.github.nogueiralegacy.ds;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestExpressao {
    @Test
    void testExpressao() {
        float resultadoEsperado = 11.0f;

        float resultado = new Soma(new Constante(5), new Multiplica(new Constante(2), new Constante(3))).valor();

        assertEquals(resultadoEsperado, resultado);
    }
}
