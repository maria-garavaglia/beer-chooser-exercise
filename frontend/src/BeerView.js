import './BeerView.css'

export default function BeerListView({beer})
{
    function formatBrewery()
    {
        if (beer.brewery)
        {
            var brewery = beer.brewery;

            var str = brewery.name;
            if (brewery.city)
            {
                str += " - " + brewery.city;
                if (brewery.state)
                {
                    str += ", " + brewery.state;
                }
            }
            else if (brewery.state)
            {
                str += " - " + beer.brewery.state;
            }
            return str;
        }

        return "Brewery Unknown";
    }

    function formatAbv()
    {
        return Math.round(beer.abv * 100) / 100;
    }

    return (
        <div class="beerView">
            <h3 class="name">
                {beer.name}
            </h3>
            <p class="styleAbv">
                {beer.style} - {formatAbv()}%
            </p>
            <p class="description">
                {beer.description}
            </p>
            <p class="brewery">{formatBrewery()}</p>
        </div>
    );
}