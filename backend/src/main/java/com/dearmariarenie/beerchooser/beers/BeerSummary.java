package com.dearmariarenie.beerchooser.beers;

/**
 * Contains information on a single beer, organized and pared down for easier viewing.
 */
public record BeerSummary(
    int id,
    String name,
    String style,
    double abv,
    String description,
    Brewery brewery
){
    public BeerSummary(Beer beer, Brewery brewery)
    {
        this(
            beer.id(),
            beer.name(),
            beer.style_name(),
            beer.abv(),
            beer.descript(),
            brewery
        );
    }
}
