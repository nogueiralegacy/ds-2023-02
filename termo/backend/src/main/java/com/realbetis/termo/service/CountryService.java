package com.realbetis.termo.service;

import com.realbetis.termo.entity.Country;
import com.realbetis.termo.entity.CountryComparison;
import com.realbetis.termo.repository.CountryRepositoryJSON;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@EnableScheduling
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

    private void randomizeCountry(){
        List<String> isoCodeList = new ArrayList<>(countries.keySet());
        Random randomizer = new Random();

        dailyCountry = countries.get(isoCodeList.get(randomizer.nextInt(isoCodeList.size())));
        System.out.println("(+) New Country Selected!");
    }

    @EventListener(ApplicationReadyEvent.class)
    private void loadDataOnStartUp(){
        this.countries = findAll();
        System.out.println("(+) Data Loaded!");

        randomizeCountry();
    }

    @Scheduled(cron = "0 0 0 * * *", zone = "GMT-3")
    public void updateSchedule(){
        System.out.println("(*) Update country schedule initialized!");
        randomizeCountry();
    }
}
