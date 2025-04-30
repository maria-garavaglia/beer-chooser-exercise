package com.dearmariarenie.beerchooser.breweries;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BreweryService
{
    @Autowired
    private List<Brewery> breweryList;

    public List<Brewery> findAllBreweries()
    {
        return breweryList;
    }
    public Optional<Brewery> findBreweryById(int id)
    {
        return breweryList.stream()
            .filter(b -> b.getId() == id)
            .findFirst()
            ;
    }
}

