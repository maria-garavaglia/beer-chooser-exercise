package com.dearmariarenie.beerchooser.beers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Brewery(
    int id,
    String name,
    String address1,
    String city,
    String state,
    String code,
    String country,
    String phone,
    String website,
    String filepath,
    String descript,
    double latitude,
    double longitude
)
{}
