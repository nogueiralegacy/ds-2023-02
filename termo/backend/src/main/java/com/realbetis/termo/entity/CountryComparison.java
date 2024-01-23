package com.realbetis.termo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;

@Data
@NoArgsConstructor
public class CountryComparison implements Serializable {
    private String name;
    private HashMap<String, Object> currenciesComparison;
    private HashMap<String, Object> coordinateComparison;
    private HashMap<String, Object> coastalComparison;
    private HashMap<String, Object> borderComparison;
    private HashMap<String, Object> continentComparison;
    private HashMap<String, Object> habitantsComparison;
    private HashMap<String, Object> areaComparison;

}
