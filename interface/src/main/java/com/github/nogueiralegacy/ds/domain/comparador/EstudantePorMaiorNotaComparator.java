package com.github.nogueiralegacy.ds.domain.comparador;

import com.github.nogueiralegacy.ds.domain.Estudante;

import java.util.Comparator;

public class EstudantePorMaiorNotaComparator implements Comparator<Estudante> {
    @Override
    public int compare(Estudante o1, Estudante o2) {
        return Double.compare(o1.getMaiorNota(), o2.getMaiorNota());
    }
}
