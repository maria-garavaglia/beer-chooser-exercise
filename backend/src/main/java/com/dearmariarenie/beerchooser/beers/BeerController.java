package com.dearmariarenie.beerchooser.beers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("beers")
public class BeerController
{
    @Autowired
    private BeerService service;

    @GetMapping
    public ResponseEntity<List<BeerSummary>> getAllBeers()
    {
        return new ResponseEntity<>(service.findAllBeers(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<BeerSummary>> searchBeers(@RequestBody BeerSearchCriteria criteria)
    {
        return new ResponseEntity<>(service.searchBeers(criteria), HttpStatus.OK);
    }
}
