package com.github.nogueiralegacy.ds.domain.comparador;

import com.github.nogueiralegacy.ds.domain.Estudante;

import java.util.Comparator;

public class EstudantePorSobrenomeomeComparator implements Comparator<Estudante> {
    @Override
    public int compare(Estudante o1, Estudante o2) {
        String sobrenome1 = o1.getNomeCompleto().split(" ")[1];
        String sobrenome2 = o2.getNomeCompleto().split(" ")[1];

        return sobrenome1.compareTo(sobrenome2);
    }
}
