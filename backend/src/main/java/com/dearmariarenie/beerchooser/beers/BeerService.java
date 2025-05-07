package com.dearmariarenie.beerchooser.beers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service providing a list of requested beers in summary format.
 */
@Service
public class BeerService
{
    @Autowired
    private List<Beer> beerList;
    @Autowired
    private List<Brewery> breweryList;

    /**
     * Returns the full list of beers, converted to summary format.
     */
    public List<BeerSummary> findAllBeers()
    {
        return beerList.stream().map(beer ->
            new BeerSummary(
                beer,
                // find brewery corresponding to ID (if it exists)
                findBrewery(beer.brewery_id()).orElse(null)
            )
        ).toList();
    }

    /**
     * Returns a list of beers matching the given search criteria, converted to summary format.
     */
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

    /**
     * Finds the brewery matching the given ID, if it exists.
     */
    private Optional<Brewery> findBrewery(int breweryId)
    {
        return breweryList.stream()
            .filter(brewery -> brewery.id() == breweryId)
            .findFirst()
        ;
    }
}
