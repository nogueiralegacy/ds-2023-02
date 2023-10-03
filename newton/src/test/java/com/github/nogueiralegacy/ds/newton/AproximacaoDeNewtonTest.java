package com.github.nogueiralegacy.ds.newton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AproximacaoDeNewtonTest {
    @Test
    void TestAproximacaoDeNewtonValido() {
        double numero = 25;

        Matematica matematica = new AproximacaoDeNewton();

        assertEquals(5, matematica.sqrt(numero));
    }
}
