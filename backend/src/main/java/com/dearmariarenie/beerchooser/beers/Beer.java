package com.dearmariarenie.beerchooser.beers;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Beer
{
    @JsonAlias("id")
    private int id = -1;
    @JsonAlias("name")
    private String name = "";
    @JsonAlias("abv")
    private double abv = 0.0;
    @JsonAlias("style_name")
    private String style = "";
    @JsonAlias("descript")
    private String description = "";
    @JsonAlias("brewery_id")
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
