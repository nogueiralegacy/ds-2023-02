package com.realbetis.termo.service;

import com.realbetis.termo.entity.Country;
import com.realbetis.termo.repository.CountryRepositoryJSON;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private CountryRepositoryJSON repository;

    public CountryService(CountryRepositoryJSON repository) {
        this.repository = repository;
    }

    public List<Country> findAll(){
        return repository.findAll();
    }
}
