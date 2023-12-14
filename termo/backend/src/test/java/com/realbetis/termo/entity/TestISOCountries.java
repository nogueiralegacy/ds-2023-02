package com.realbetis.termo.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestISOCountries {
    @Test
    void testGetCountryName() {
        String brasil = ISOCountries.getCountryName("BR");

        assertEquals("Brasil", brasil);
    }
}
