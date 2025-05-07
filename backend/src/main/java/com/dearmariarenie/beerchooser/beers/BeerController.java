package com.dearmariarenie.beerchooser.beers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST API controller providing lists of beers on request
 */
@RestController
@RequestMapping("beers")
public class BeerController
{
    @Autowired
    private BeerService service;

    /**
     * Provides the full list of beers in the database.
     */
    @GetMapping
    public ResponseEntity<List<BeerSummary>> getAllBeers()
    {
        return new ResponseEntity<>(service.findAllBeers(), HttpStatus.OK);
    }

    /**
     * Returns a list of beers matching a given set of criteria. searchBeers("", "", 0, 100) is
     * equivalent to getAllBeers().
     * @param name Name of the beer. Optional.empty or empty string accepts any name.
     * @param style Style of the beer. Optional.empty or empty string accepts any style.
     * @param abvMin Minimum alcohol by volume (ABV), if any.
     *               Optional.empty treats the minimum as 0.
     * @param abvMax Maximum alcohol by volume (ABV), if any.
     *               Optional.empty treats the maximum as 100.
     * @return a list of beers matching the given criteria.
     */
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
