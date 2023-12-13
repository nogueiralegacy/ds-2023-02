package com.realbetis.termo.config;

import com.realbetis.termo.entity.Country;
import com.realbetis.termo.repository.CountryRepository;
import com.realbetis.termo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("test")
public class TestConfig  implements CommandLineRunner {

    @Autowired
    private CountryService service;

    @Override
    public void run(String... args) throws Exception {
        List<Country> teste = service.findAllCountries();
        for(Country c : teste){
            System.out.println("Nome: " + c.getName());
        }
    }
}
