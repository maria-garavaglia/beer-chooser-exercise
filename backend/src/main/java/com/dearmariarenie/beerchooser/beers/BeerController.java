package com.dearmariarenie.beerchooser.beers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<List<BeerSummary>> searchBeers(
        @RequestParam Optional<String> name,
        @RequestParam Optional<String> style,
        @RequestParam Optional<Double> abvMin,
        @RequestParam Optional<Double> abvMax
    )
    {
        var criteria = new BeerSearchCriteria(name, style, abvMin, abvMax);
        return new ResponseEntity<>(service.searchBeers(criteria), HttpStatus.OK);
    }
}
