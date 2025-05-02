package com.dearmariarenie.beerchooser;

import com.dearmariarenie.beerchooser.beers.Beer;
import com.dearmariarenie.beerchooser.beers.Brewery;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Main
{

    public static void main(String[] args)
    {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer()
    {
        return new WebMvcConfigurer()
        {
            @Override
            public void addCorsMappings(CorsRegistry registry)
            {
                registry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowedMethods("*")
                    .allowedHeaders("*")
                    .allowCredentials(false).maxAge(3600)
                ;
            }
        };
    }

    // Since this is just an exercise, we'll just read in the list of beers/breweries directly from
    // JSON instead of creating a whole database + Repository classes
    @Bean
    public List<Beer> beerList(@Value("classpath:beers.json") Resource data)
    {
        final String BEERS_FILENAME = "beers.json";
        var jsonReader = new ObjectMapper();
        try
        {
            System.out.print("Loading beers from JSON... ");
            var beerList = jsonReader.readValue(
                data.getFile(),
                new TypeReference<List<Beer>>(){}
            );
            System.out.println(beerList.size() + " beers loaded");
            return beerList;
        }
        catch (IOException e)
        {
            System.out.println("Failed to load beer list '" + BEERS_FILENAME + "': " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Since this is just an exercise, we'll just read in the list of beers/breweries directly from
    // JSON instead of creating a whole database + Repository classes
    @Bean
    public List<Brewery> breweryList(@Value("classpath:breweries.json") Resource data)
    {
        final String BREWERIES_FILENAME = "breweries.json";
        var jsonReader = new ObjectMapper();
        try
        {
            System.out.print("Loading breweries from JSON... ");
            var breweryList = jsonReader.readValue(data.getFile(), new TypeReference<List<Brewery>>(){});
            System.out.println(breweryList.size() + " beers loaded");
            return breweryList;
        }
        catch (IOException e)
        {
            System.out.println("Failed to load brewery list '" + BREWERIES_FILENAME + "': " + e.getMessage());
            return new ArrayList<>();
        }
    }
}