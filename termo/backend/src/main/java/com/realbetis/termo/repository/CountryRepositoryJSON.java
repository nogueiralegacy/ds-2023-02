package com.realbetis.termo.repository;

import com.google.gson.Gson;
import com.realbetis.termo.entity.Country;
import com.realbetis.termo.utils.DTOCountryInput;
import com.realbetis.termo.utils.Utils;

import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CountryRepositoryJSON implements CountryRepository{
    Gson gson = new Gson();
    Path countriesPath = new Utils().getPath("countries.json");


    //TODO Esse método deveria retornar um Map com chave sendo o code e o country como valor
    // facilitando as operações de busca
    public List<Country> findAll() {
        DTOCountryInput[] dtoCountryInputs = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(countriesPath.toString()))) {

            dtoCountryInputs = gson.fromJson(reader, DTOCountryInput[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Country> countries = new ArrayList<>();

        for (DTOCountryInput dto : dtoCountryInputs) {
            countries.add(dto.toCountry());
        }

        return countries;
    }
}
