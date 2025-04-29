package com.dearmariarenie.beerchooser.beers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeerService
{
    @Autowired
    private List<Beer> beerList;

    public List<Beer> findAllBeers()
    {
        return beerList;
    }
    public Optional<Beer> findBeerById(int id)
    {
        return beerList.stream()
            .filter(b -> b.getId() == id)
            .findFirst()
        ;
    }
}
