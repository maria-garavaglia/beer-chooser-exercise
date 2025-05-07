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
        // Filter out beers by each criterion, then convert each to a summary class containing data to be displayed
        return beerList.stream()
            .filter(b -> b.matchesSearch(criteria))
            .map(beer ->
                new BeerSummary(
                    beer,
                    // find brewery corresponding to ID (if it exists)
                    findBrewery(beer.brewery_id()).orElse(null)
                )
            )
            .toList()
        ;
    }

    private Optional<Brewery> findBrewery(int breweryId)
    {
        return breweryList.stream()
            .filter(brewery -> brewery.id() == breweryId)
            .findFirst()
        ;
    }
}
