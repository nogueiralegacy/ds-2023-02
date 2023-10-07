package com.github.nogueiralegacy.ds.newton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AproximacaoDeNewtonTest {
    @Test
    void TestAproximacaoDeNewtonValido() {
        double numero = 25;

       AproximacaoDeNewton newton = new AproximacaoDeNewton();

        assertEquals(5, newton.sqrt(numero));
    }
}
