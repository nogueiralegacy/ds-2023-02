package com.realbetis.termo.service;

import com.realbetis.termo.entity.Country;
import com.realbetis.termo.repository.CountryRepositoryJSON;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CountryService {

    private final CountryRepositoryJSON repository;

    public CountryService(CountryRepositoryJSON repository) {
        this.repository = repository;
    }

    public Map<String, Country> findAll(){
        return repository.findAll();
    }

}
