package com.dearmariarenie.beerchooser.beers;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

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

    public List<Beer> searchBeers(BeerSearchCriteria criteria)
    {
        // Filter out beers by each criterion. If criterion is empty, use a default value that will
        // catch everything
        // TODO maybe make this a function in Beer class instead?
        return beerList.stream()
            .filter(b -> containsIgnoreCase(b.getName(), criteria.name().orElse("")))
            .filter(b -> containsIgnoreCase(b.getStyle(), criteria.style().orElse("")))
            .filter(b -> b.getAbv() >= criteria.abvMin().orElse(0.0))
            .filter(b -> b.getAbv() <= criteria.abvMax().orElse(100.0))
            .toList()
        ;
    }

    /**
     * convenience function for finding substrings while ignoring case
     */
    private boolean containsIgnoreCase(String str, String sub)
    {
        return str.toLowerCase().contains(sub.toLowerCase());
    }
}
