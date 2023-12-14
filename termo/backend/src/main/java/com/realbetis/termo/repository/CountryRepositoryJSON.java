package com.realbetis.termo.repository;

import com.realbetis.termo.entity.Country;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CountryRepositoryJSON implements CountryRepository{

    private JSONParser jsonParser = new JSONParser();
    private static final List<Country> countries = new ArrayList<>();
    public List<Country> findAll(){

        try(FileReader fileReader = new FileReader("src/main/resources/realbetis_countries.json")){
            Object obj = jsonParser.parse(fileReader);

            JSONArray countriesList = (JSONArray) obj;

            countriesList.forEach(country -> parseCountryObject((JSONObject) country));

        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return countries;
    }

    private static void parseCountryObject(JSONObject jsonObject){
        Country country = new Country();

        JSONObject nestedNameObject = (JSONObject) jsonObject.get("name");
        country.setName((String) nestedNameObject.get("common"));

        countries.add(country);
    }

}
