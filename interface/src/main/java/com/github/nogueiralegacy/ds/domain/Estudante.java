package com.github.nogueiralegacy.ds.domain;

import lombok.Data;

import java.util.List;

@Data
public class Estudante {
    private String nomeCompleto;
    private int idade;
    private List<Double> notas;


    public Estudante(String nomeCompleto, int idade, List<Double> notas) {
        this.nomeCompleto = nomeCompleto;
        this.idade = idade;
        this.notas = notas;
    }

    public double getMedia() {
        double sum = 0;
        for (double nota : notas) {
            sum += nota;
        }

        return sum / notas.size();
    }

    public double getMaiorNota() {
        double maiorNota = 0;
        for (double nota : notas) {
            if (nota > maiorNota) {
                maiorNota = nota;
            }
        }

        return maiorNota;
    }

}
