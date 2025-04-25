package com.dearmariarenie.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Brewery
{
    @JsonProperty("id")
    private int id = -1;
    @JsonProperty("name")
    private String name = "";
    // TODO include other info to display?

    public Brewery()
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
}
