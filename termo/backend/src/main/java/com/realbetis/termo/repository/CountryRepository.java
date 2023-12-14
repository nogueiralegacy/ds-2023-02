package com.realbetis.termo.repository;

import java.util.List;

import com.realbetis.termo.entity.Country;

public interface CountryRepository {
    
    List<Country> findAll();
}
