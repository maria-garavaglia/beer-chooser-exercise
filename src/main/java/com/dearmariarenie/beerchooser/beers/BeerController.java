package com.dearmariarenie.beerchooser.beers;

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
@RequestMapping("api/v1/beers")
public class BeerController
{
    @Autowired
    private BeerService service;

    @GetMapping
    public ResponseEntity<List<Beer>> getAllBeers()
    {
        return new ResponseEntity<List<Beer>>(service.findAllBeers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Beer>> getBeer(@PathVariable String id)
    {
        var idInt = Integer.parseInt(id); // TODO NumberFormatException
        return new ResponseEntity<Optional<Beer>>(service.findBeerById(idInt), HttpStatus.OK);
    }
}
