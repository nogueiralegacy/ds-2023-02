package com.realbetis.termo.service;

import com.realbetis.termo.entity.Country;
import com.realbetis.termo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    public List<Country> findAllCountries(){
        return repository.findAllCountries();
    }
}
