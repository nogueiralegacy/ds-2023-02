package com.github.nogueiralegacy.ds.testa_newton;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestAproximacaoDeNewton {

    @Test
    void TestAproximacaoDeNewton() {
        Function<Double, Double> minhaRaiz = getObject("com.github.nogueiralegacy.ds.newton.AproximacaoDeNewton");
        assertEquals(3.0, minhaRaiz.apply(9.0));
    }

    private static Function<Double, Double> getObject(String classname) {
        try {
            Class<?> classe = Class.forName(classname);
            return (Function<Double,Double>)
                    classe.getDeclaredConstructors()[0].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}