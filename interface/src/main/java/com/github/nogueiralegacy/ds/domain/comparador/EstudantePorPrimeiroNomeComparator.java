package com.github.nogueiralegacy.ds.domain.comparador;

import com.github.nogueiralegacy.ds.domain.Estudante;

import java.util.Comparator;

public class EstudantePorPrimeiroNomeComparator implements Comparator<Estudante> {
    @Override
    public int compare(Estudante o1, Estudante o2) {
        String primeiroNome1 = o1.getNomeCompleto().split(" ")[0];
        String primeiroNome2 = o2.getNomeCompleto().split(" ")[0];

        return primeiroNome1.compareTo(primeiroNome2);
    }
}
