package com.realbetis.termo.repository;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.realbetis.termo.entity.Country;
import com.realbetis.termo.service.CountryService;

public class TestCountry  {

    @Autowired
    CountryService service;

    @Test
    void countryName() {
        List<Country> test = service.findAll();
        for(Country country : test){
            System.out.println("Nome: " + country.getName());
        }
    }
}
