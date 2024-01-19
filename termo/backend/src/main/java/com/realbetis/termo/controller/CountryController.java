package com.realbetis.termo.controller;

import com.realbetis.termo.entity.Country;
import com.realbetis.termo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/country")
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping
    public ResponseEntity<List<Country>> findAll(){
        List<Country> list = this.service.findAll();
        return ResponseEntity.ok(list);
    }


}
