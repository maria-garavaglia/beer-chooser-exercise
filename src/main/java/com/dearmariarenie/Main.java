package com.dearmariarenie;

import com.dearmariarenie.models.Beer;
import com.dearmariarenie.models.Brewery;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    private static final String BEERS_FILENAME = "beers.json";
    private static final String BREWERIES_FILENAME = "breweries.json";

    public static void main(String[] args)
    {
        var app = new Main();

        var jsonReader = new ObjectMapper();
        List<Beer> beerList = null;
        List<Brewery> breweryList = null;

        try
        {
            System.out.print("Loading beers from JSON... ");
            beerList = jsonReader.readValue(Main.class.getResource(BEERS_FILENAME), new TypeReference<List<Beer>>(){});
            System.out.println(beerList.size() + " beers loaded");
        }
        catch (IOException e)
        {
            System.out.println("Failed to load beer list '" + BEERS_FILENAME + "': " + e.getMessage());
            beerList = new ArrayList<>();
        }

        try
        {
            System.out.print("Loading breweries from JSON... ");
            breweryList = jsonReader.readValue(Main.class.getResource(BREWERIES_FILENAME), new TypeReference<List<Brewery>>(){});
            System.out.println(breweryList.size() + " beers loaded");
        }
        catch (IOException e)
        {
            System.out.println("Failed to load brewery list '" + BREWERIES_FILENAME + "': " + e.getMessage());
            breweryList = new ArrayList<>();
        }
    }
}