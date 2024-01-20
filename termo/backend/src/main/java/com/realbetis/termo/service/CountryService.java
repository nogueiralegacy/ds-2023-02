package com.realbetis.termo.service;

import com.realbetis.termo.entity.Country;
import com.realbetis.termo.entity.CountryComparison;
import com.realbetis.termo.repository.CountryRepositoryJSON;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepositoryJSON repository;
    //TODO
    // INSTANCIAR O PAIS DIARIO SELECIONADO PELO SERVIDOR
    // FAZER UMA ROTINA PRA QUANDO O SERVIDOR STARTAR ELE JÁ ESCOLHER UM PAIS ALEATORIO
    // DEPOIS DE INSTANCIADO NÃO PRECISA CONSULTAR DE NOVO NO BANCO E DA PRA FAZER A COMPARACAO
    private Country dailyCountry;

    public CountryService(CountryRepositoryJSON repository) {
        this.repository = repository;
    }

    public List<Country> findAll(){
        return repository.findAll();
    }

    public CountryComparison compare (Country countryGuessed){
        return dailyCountry.compare(countryGuessed);
    }


}
