package com.github.nogueiralegacy.ds.domain.comparador;

import com.github.nogueiralegacy.ds.domain.Estudante;

import java.util.Comparator;

public class EstudantePorMediaComparator implements Comparator<Estudante> {
    @Override
    public int compare(Estudante o1, Estudante o2) {
        return Double.compare(o1.getMedia(), o2.getMedia());
    }
}
