package com.dearmariarenie.beerchooser.beers;

import java.util.Optional;

/**
 * Contains information pertaining to a single search for matching beers.
 */
public record BeerSearchCriteria(
    Optional<String> name,
    Optional<String> style,
    Optional<Double> abvMin,
    Optional<Double> abvMax
)
{
}
