package com.github.nogueiralegacy.ds.newton;

public class AproximacaoDeNewton implements Matematica{
    private static final double precisao = Math.pow(10, -5);
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
