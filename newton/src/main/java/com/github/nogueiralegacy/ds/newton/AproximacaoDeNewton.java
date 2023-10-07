package com.github.nogueiralegacy.ds.newton;

import java.util.function.Function;

public class AproximacaoDeNewton implements Function<Double, Double> {
    private final double precisao = Math.pow(10, -5);
    @Override
    public Double apply(Double numero) {
        return sqrt(numero);
    }
    public double sqrt(double numero) {
        double aproximacao = numero;

        while (true) {
            double novaAproximacao;
            novaAproximacao = 0.5 * (aproximacao + numero / aproximacao);

            if (Math.abs(numero - (novaAproximacao * novaAproximacao)) < precisao) {
                return Math.round(novaAproximacao * 100000.0) / 100000.0;
            }

            aproximacao = novaAproximacao;
        }
    }
}
