package com.realbetis.termo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/country")
public class CountryController {

    @GetMapping
    public String view() {
        return "Estou aqui";
    }

}
