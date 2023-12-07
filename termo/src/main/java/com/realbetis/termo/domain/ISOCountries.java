package com.realbetis.termo.domain;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ISOCountries {
    private static final Map<String, String> COUNTRY_CODE;

    static {
        String[] codes = Locale.getISOCountries();

        COUNTRY_CODE = new HashMap<>(codes.length);


        for (String code : codes) {
            // Set the language of country name
            Locale locale = new Locale("pt", code);
            COUNTRY_CODE.put(code, locale.getDisplayCountry(locale));
        }
    }

    // Code (ISO 3166-1 alpha-2) of th country
    public static String getCountryName(String code) {
        return COUNTRY_CODE.get(code);
    }
}
