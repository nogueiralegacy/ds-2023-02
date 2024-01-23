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

    public CountryComparison compare(Country countryGuessed){
        CountryComparison comparison = new CountryComparison();

        comparison.setName(countryGuessed.getName());

        for(Field field : countryGuessed.getClass().getDeclaredFields()){
            HashMap<String, Object> map = new HashMap<>();

            try{
                map.put("valueGuessed", field.get(countryGuessed));

                switch (field.getName()){
                    case "currencies":
                        map.put("equals", new HashSet<>(countryGuessed.getCurrencies()).containsAll(this.getCurrencies()));
                        comparison.setCurrenciesComparison(map);
                        break;
                    case "coordinate":
                        map.put("latitudeDiff", Math.abs(this.getCoordinate().getLatitude()) - Math.abs(countryGuessed.getCoordinate().getLatitude()));
                        map.put("longitudeDiff", Math.abs(this.getCoordinate().getLatitude()) - Math.abs(countryGuessed.getCoordinate().getLongitude()) );
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
                        map.put("habitantsDiff", this.getHabitants() - countryGuessed.getHabitants());
                        comparison.setHabitantsComparison(map);
                        break;
                    case "area":
                        map.put("areaDiff", this.getArea() - countryGuessed.getArea());
                        comparison.setAreaComparison(map);
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
        return Objects.hash(isoCode, currencies, coordinate, coastal, borders, continent, habitants, area);
    }
}
