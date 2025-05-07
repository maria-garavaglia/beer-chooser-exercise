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
) {
    /**
     * Checks if this beer matches a particular set of search criteria
     */
    public boolean matchesSearch(BeerSearchCriteria criteria)
    {
        // If criterion is empty, use a default value that will catch everything
        return
            containsIgnoreCase(name, criteria.name().orElse(""))
            && containsIgnoreCase(style_name, criteria.style().orElse(""))
            && abv >= criteria.abvMin().orElse(0.0)
            && abv <= criteria.abvMax().orElse(100.0)
        ;
    }

    /**
     * convenience function for finding substrings while ignoring case
     */
    private boolean containsIgnoreCase(String str, String sub)
    {
        if (str == null)
        {
            return sub == null || sub.isEmpty();
        }
        if (sub == null)
        {
            return true;
        }
        return str.toLowerCase().contains(sub.toLowerCase());
    }
}
