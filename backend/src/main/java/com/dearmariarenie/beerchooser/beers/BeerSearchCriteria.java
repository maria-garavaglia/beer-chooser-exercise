package com.dearmariarenie.beerchooser.beers;

import java.util.Optional;

public record BeerSearchCriteria(
    Optional<String> name,
    Optional<String> style,
    Optional<Double> abvMin,
    Optional<Double> abvMax
)
{
}
