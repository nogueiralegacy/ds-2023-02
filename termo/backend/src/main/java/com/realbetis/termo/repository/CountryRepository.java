package com.realbetis.termo.repository;

import java.util.Map;

import com.realbetis.termo.entity.Country;

public interface CountryRepository {
    
    Map<String,Country> findAll();
}
