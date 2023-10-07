package com.github.nogueiralegacy.ds.domain.comparador;

import com.github.nogueiralegacy.ds.domain.Estudante;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class SetUp {
    public static List<Estudante> getEstudantes() {
        List<Estudante> estudantes = new ArrayList<>();

        estudantes.add(new Estudante("Mariana Torres", 21, List.of(5.8, 7.6, 8.8)));
        estudantes.add(new Estudante("Pedro Nogueira", 18, List.of(6.8, 7.8, 9.7)));
        estudantes.add(new Estudante("Thiago Afonso", 20, List.of(8.8, 9.8, 9.7)));
        estudantes.add(new Estudante("George Abravanel", 22, List.of(7.8, 8.8, 6.7)));
        estudantes.add(new Estudante("Larissa Santos", 21, List.of(9.0, 6.8, 3.9)));
        estudantes.add(new Estudante("Ana Flavia", 19, List.of(7.8, 8.8, 6.7)));
        estudantes.add(new Estudante("Ana Maria", 23, List.of(9.0, 6.8, 3.9)));

        return estudantes;
    }
}
