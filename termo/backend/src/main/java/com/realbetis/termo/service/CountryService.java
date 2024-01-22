package com.realbetis.termo.service;

import com.realbetis.termo.entity.Country;
import com.realbetis.termo.entity.CountryComparison;
import com.realbetis.termo.repository.CountryRepositoryJSON;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CountryService {

    private final CountryRepositoryJSON repository;
    private Country dailyCountry;
    private HashMap<String, Country> countries = new HashMap<>();

    public CountryService(CountryRepositoryJSON repository) {
        this.repository = repository;
    }

    public HashMap<String, Country> findAll(){
        return repository.findAll();
    }

    public CountryComparison compare (String isoCode){
        Country countryGuessed = countries.get(isoCode);

        return dailyCountry.compare(countryGuessed);
    }

    public Country dailyCountry(){
        return this.dailyCountry;
    }

    @EventListener(ApplicationReadyEvent.class)
    private void loadDataOnStartUp(){
        this.countries = findAll();
        System.out.println("(+) Data Loaded!");

        List<String> isoCodeList = new ArrayList<>(countries.keySet());
        Random randomizer = new Random();

        dailyCountry = countries.get(isoCodeList.get(randomizer.nextInt(isoCodeList.size())));
        System.out.println("(+) Country Selected!");

    }
}
