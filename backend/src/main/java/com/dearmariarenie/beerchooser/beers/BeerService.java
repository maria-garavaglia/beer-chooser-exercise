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
    @Autowired
    private List<Brewery> breweryList;

    public List<BeerSummary> findAllBeers()
    {
        return beerList.stream().map(beer ->
            new BeerSummary(
                beer,
                findBrewery(beer.brewery_id()).orElse(null)
            )
        ).toList();
    }

    public List<BeerSummary> searchBeers(BeerSearchCriteria criteria)
    {
        // Filter out beers by each criterion. If criterion is empty, use a default value that will
        // catch everything
        // TODO maybe make this a function in Beer class instead?
        return beerList.stream()
            .filter(b -> containsIgnoreCase(b.name(), criteria.name().orElse("")))
            .filter(b -> containsIgnoreCase(b.style_name(), criteria.style().orElse("")))
            .filter(b -> b.abv() >= criteria.abvMin().orElse(0.0))
            .filter(b -> b.abv() <= criteria.abvMax().orElse(100.0))
            .map(beer ->
                new BeerSummary(
                    beer,
                    findBrewery(beer.brewery_id()).orElse(null)
                )
            )
            .toList()
        ;
    }

    /**
     * convenience function for finding substrings while ignoring case
     */
    private boolean containsIgnoreCase(String str, String sub)
    {
        if (str == null)
        {
            return sub == null || sub.isEmpty();
        }
        if (sub == null)
        {
            return true;
        }
        return str.toLowerCase().contains(sub.toLowerCase());
    }

    private Optional<Brewery> findBrewery(int breweryId)
    {
        return breweryList.stream()
            .filter(brewery -> brewery.id() == breweryId)
            .findFirst()
        ;
    }
}
