package com.realbetis.termo.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
@Builder
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

    //Equals ignore name, because name maybe is accents in data base
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return coastal == country.coastal && habitants == country.habitants && Double.compare(area, country.area) == 0 && Double.compare(HDI, country.HDI) == 0 && Double.compare(GDP, country.GDP) == 0 && Objects.equals(isoCode, country.isoCode) && Objects.equals(currencies, country.currencies) && Objects.equals(coordinate, country.coordinate) && Objects.equals(borders, country.borders) && continent == country.continent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isoCode, currencies, coordinate, coastal, borders, continent, habitants, area, HDI, GDP);
    }
}
