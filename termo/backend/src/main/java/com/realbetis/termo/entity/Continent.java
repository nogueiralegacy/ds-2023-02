package com.realbetis.termo.entity;

import lombok.Getter;

@Getter
public enum Continent {
    AFRICA("africa"),
    //TODO converter para AMERICA, AMERICAS fi uma solução paliativa
    AMERICAS("america"),
    ASIA("asia"),
    EUROPE("europe"),
    OCEANIA("oceania");

    private final String continent;

    Continent(String continent) {
        this.continent = continent;
    }
}
