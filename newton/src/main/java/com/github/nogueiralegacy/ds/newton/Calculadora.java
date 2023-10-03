package com.github.nogueiralegacy.ds.newton;

public class Calculadora {
    public static double aproximacaoDeNewton(double numero, double precisao) {
        double aproximacao = numero;

        while (true) {
            double novaAproximacao;
            novaAproximacao = 0.5 * (aproximacao + numero / aproximacao);

            if ((aproximacao - novaAproximacao) < precisao) {
                return novaAproximacao;
            }

            aproximacao = novaAproximacao;
        }
    }
}
