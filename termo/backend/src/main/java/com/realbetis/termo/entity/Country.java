package com.realbetis.termo.entity;

import lombok.Builder;
import lombok.Data;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
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
    private double HDI;
    private double GDP;

    public CountryComparison compare(Country countryGuessed){
        CountryComparison comparison = new CountryComparison();

        comparison.setName(countryGuessed.getName());

        for(Field field : countryGuessed.getClass().getFields()){
            HashMap<String, Object> map = new HashMap<>();

            try{
                map.put("valueGuessed", field.get(countryGuessed));

                switch (field.getName()){
                    case "currencies":
                        map.put("equals", new HashSet<>(countryGuessed.getCurrencies()).containsAll(this.getCurrencies()));
                        comparison.setCurrenciesComparison(map);
                        break;
                    case "coordinate":
                        map.put("latitudeDiff", Objects.equals(countryGuessed.getCoordinate().getLatitude(), this.getCoordinate().getLatitude()));
                        map.put("longitudeDiff", Objects.equals(countryGuessed.getCoordinate().getLongitude(), this.getCoordinate().getLatitude()));
                        comparison.setCoordinateComparison(map);
                        break;
                    case "continent": 
                        map.put("equals", Objects.equals(countryGuessed.getContinent(), this.getContinent()));
                        comparison.setContinentComparison(map);
                        break;
                    case "borders":
                        map.put("equals", new HashSet<>(countryGuessed.getBorders()).contains(this.getName()));
                        comparison.setBorderComparison(map);
                        break;
                    case "coastal":
                        map.put("equals", Objects.equals(countryGuessed.isCoastal(), this.isCoastal()));
                        comparison.setCoastalComparison(map);
                        break;
                    case "habitants":
                        map.put("habitantsDiff", countryGuessed.getHabitants() - this.getHabitants());
                        comparison.setHabitantsComparison(map);
                        break;
                    case "area":
                        map.put("areaDiff", countryGuessed.getArea() - this.getArea());
                        comparison.setAreaComparison(map);
                        break;
                    case "HDI":
                        map.put("hdiDiff", countryGuessed.getHDI() - this.getHDI());
                        comparison.setHdiComparison(map);
                        break;
                    case "GDP":
                        map.put("gdpDiff", countryGuessed.getGDP() - this.getGDP());
                        comparison.setGdpComparison(map);
                        break;
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

        return comparison;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isoCode, currencies, coordinate, coastal, borders, continent, habitants, area, HDI, GDP);
    }
}
