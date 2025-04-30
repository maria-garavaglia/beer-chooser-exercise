package com.dearmariarenie.beerchooser.beers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Beer
{
    @JsonProperty("id")
    private int id = -1;
    @JsonProperty("name")
    private String name = "";
    @JsonProperty("abv")
    private double abv = 0.0;
    @JsonProperty("style_name")
    private String style = "";
    @JsonProperty("descript")
    private String description = "";
    @JsonProperty("brewery_id")
    private int breweryId = -1;

    public Beer()
    {
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public double getAbv()
    {
        return abv;
    }

    public String getStyle()
    {
        return style;
    }

    public String getDescription()
    {
        return description;
    }

    public int getBreweryId()
    {
        return breweryId;
    }
}
