package com.realbetis.termo.entity;

import lombok.Data;

import java.util.List;

@Data
public class Country {
    private String name;
    private String isoCode;
    private List<String> currencies;
    private Coordinate coordinate;
    private boolean coastal;
    private List<String> borders;
    private Continent continent;
    private int habitants;
    private double area;
    //idh
    private double HDI;
    //pib
    private double GDP;
}
