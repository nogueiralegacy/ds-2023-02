package com.realbetis.termo.domain;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

@Data
public class Pais {
    private String nome;
    private String isoCode;
    private String moeda;
    private Coordenada coordenada;
    private boolean litoraneo;
    private List<String> fronteiras;
    private Continente continente;
    private int quantidadeHabitantes;
    private double area;
    private double IDH;
    private double PIB;
}
