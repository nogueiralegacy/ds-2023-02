package com.realbetis.termo.repository;

import com.realbetis.termo.entity.Continent;
import com.realbetis.termo.entity.Coordinate;
import com.realbetis.termo.entity.Country;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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

    //TODO melhorar metodo de teste assim que conver ter o findAll para retornar um Map de (isoCode, country)
    @Test
    void testCarregamento() {
        List<Country> countries = repository.findAll();

        for (Country country : countries) {
            if (country.getIsoCode().equals("RU")) {
                assertEquals(countryExpected, country);
                break;
            }

        }
    }

}
