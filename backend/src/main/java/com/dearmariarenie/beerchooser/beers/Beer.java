package com.dearmariarenie.beerchooser.beers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Beer(
    int id,
    int brewery_id,
    String name,
    double abv,
    double ibu,
    double srm,
    int upc,
    String style_name,
    String descript
) {}
