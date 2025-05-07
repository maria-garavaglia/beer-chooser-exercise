package com.dearmariarenie.beerchooser;

import com.dearmariarenie.beerchooser.beers.Beer;
import com.dearmariarenie.beerchooser.beers.Brewery;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Main back-end entry point
 */
@SpringBootApplication
public class Main
{
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private static final String BEERS_FILENAME = "beers.json";
    private static final String BREWERIES_FILENAME = "breweries.json";

    public static void main(String[] args)
    {
        SpringApplication.run(Main.class, args);
    }

    /**
     * Basic webapp configuration
     */
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
    public List<Beer> beerList(@Value("classpath:" + BEERS_FILENAME) Resource data)
    {
        var jsonReader = new ObjectMapper();
        try
        {
            logger.info("Loading beers from JSON... ");
            var beerList = jsonReader.readValue(
                data.getFile(),
                new TypeReference<List<Beer>>(){}
            );
            logger.info("...{} beers loaded", beerList.size());
            return beerList;
        }
        catch (IOException e)
        {
            logger.error("Failed to load beer list '{}'", BEERS_FILENAME, e);
            return new ArrayList<>();
        }
    }

    // Since this is just an exercise, we'll just read in the list of beers/breweries directly from
    // JSON instead of creating a whole database + Repository classes
    @Bean
    public List<Brewery> breweryList(@Value("classpath:" + BREWERIES_FILENAME) Resource data)
    {
        var jsonReader = new ObjectMapper();
        try
        {
            logger.info("Loading breweries from JSON... ");
            var breweryList = jsonReader.readValue(
                data.getFile(),
                new TypeReference<List<Brewery>>(){}
            );
            logger.info("...{} breweries loaded", breweryList.size());
            return breweryList;
        }
        catch (IOException e)
        {
            logger.error(
                "Failed to load brewery list '{}'", BREWERIES_FILENAME, e
            );
            return new ArrayList<>();
        }
    }
}