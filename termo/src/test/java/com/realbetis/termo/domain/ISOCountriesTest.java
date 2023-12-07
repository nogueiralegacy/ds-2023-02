package com.realbetis.termo.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ISOCountriesTest {
    @Test
    void testGetCountryName() {
        String brasil = ISOCountries.getCountryName("BR");

        assertEquals("Brasil", brasil);
    }
}
