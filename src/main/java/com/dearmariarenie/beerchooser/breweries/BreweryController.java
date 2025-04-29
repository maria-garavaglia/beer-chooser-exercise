package com.dearmariarenie.beerchooser.breweries;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/breweries")
public class BreweryController
{
    @Autowired
    private BreweryService service;

    @GetMapping
    public ResponseEntity<List<Brewery>> getAllBreweries()
    {
        return new ResponseEntity<List<Brewery>>(service.findAllBreweries(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Brewery>> getBeer(@PathVariable String id)
    {
        var idInt = Integer.parseInt(id); // TODO NumberFormatException
        return new ResponseEntity<Optional<Brewery>>(service.findBreweryById(idInt), HttpStatus.OK);
    }
}
