package com.realbetis.termo.controller;

import com.realbetis.termo.entity.Country;
import com.realbetis.termo.entity.CountryComparison;
import com.realbetis.termo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/country")
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping(value = "/all")
    public ResponseEntity<Map<String, Country>> findAll(){
        Map<String, Country> countries = this.service.findAll();
        return ResponseEntity.ok(countries);
    }

    @PostMapping
    public ResponseEntity<CountryComparison> guess(@RequestParam String isoCode){
        CountryComparison comparison = service.compare(isoCode);
        return ResponseEntity.ok(comparison);
    }

    @GetMapping
    public ResponseEntity<Country> getDailyCountry(){
        Country country = service.dailyCountry();
        return ResponseEntity.ok(country);
    }
}
