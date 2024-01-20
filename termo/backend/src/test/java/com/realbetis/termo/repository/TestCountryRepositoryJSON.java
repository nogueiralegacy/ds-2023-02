package com.realbetis.termo.repository;

import com.realbetis.termo.entity.Continent;
import com.realbetis.termo.entity.Coordinate;
import com.realbetis.termo.entity.Country;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestCountryRepositoryJSON {
    CountryRepository repository = new CountryRepositoryJSON();

    Country countryExpected = Country.builder()
            .name("Russia")
            .isoCode("RU")
            .currencies(List.of("RUB"))
            .continent(Continent.EUROPE)
            .coordinate(new Coordinate(60.0, 100.0))
            .coastal(true)
            .borders(Arrays.asList("AZE","BLR","CHN","EST","FIN","GEO","KAZ","PRK","LVA","LTU","MNG","NOR","POL","UKR"))
            .area(1.7098242E7)
            .habitants(144104080)
            .build();

    @Test
    void testCarregamento() {
        Map<String, Country> countries = repository.findAll();

        for (String isoCode : countries.keySet()) {
            if (isoCode.equals("RU")) {
                assertEquals(countryExpected, countries.get(isoCode));
                break;
            }

        }
    }

}
