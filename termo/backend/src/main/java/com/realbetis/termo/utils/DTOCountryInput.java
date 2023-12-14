package com.realbetis.termo.utils;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.realbetis.termo.entity.Continent;
import com.realbetis.termo.entity.Coordinate;
import com.realbetis.termo.entity.Country;
import com.realbetis.termo.entity.ISOCountries;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TODO englobar dados do IDH e PIB

// WARNING: careful with null filds
@Data
public class DTOCountryInput {
    private String cca2;
    private boolean unMember;
    @SerializedName("currencies")
    private JsonObject currencies;
    private String region;
    private String subregion;
    private double[] latlng;
    private boolean landlocked;
    private String[] borders;
    private double area;
    private int population;

    public Country toCountry() {
        return Country.builder()
                .name(resolveName())
                .isoCode(cca2)
                .currencies(resolveCurrencies())
                .continent(resolveContinent())
                .coordinate(resolveCoordinate())
                .coastal(resolveCoastal())
                .borders(resolveBorders())
                .area(area)
                .habitants(population)
                .build();
    }

    private String resolveName() {
        return ISOCountries.getCountryName(cca2);
    }

    private List<String> resolveCurrencies() {
        List<String> currenciesStringList = new ArrayList<>();

        for (var entry : currencies.entrySet()) {
            currenciesStringList.add(entry.getKey());
        }

        return currenciesStringList;
    }

    private Continent resolveContinent() {
        return Continent.valueOf(region.toUpperCase());
    }

    private Coordinate resolveCoordinate() {
        return new Coordinate(latlng[0], latlng[1]);
    }

    private boolean resolveCoastal() {
        return !landlocked;
    }

    private List<String> resolveBorders() {
        return Arrays.asList(borders);
    }
}
