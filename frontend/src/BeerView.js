import './BeerView.css'

export default function BeerListView({beer})
{
    return (
        <div class="beerView">
            <h3 class="name">
                {beer.name}
            </h3>
            <p class="styleAbv">
                {beer.style} - {beer.abv}%
            </p>
            <p class="description">
                {beer.description}
            </p>
            <p class="brewery">{
                beer.brewery
                    ? beer.brewery.name + " - "
                        + beer.brewery.city + ", "
                        + beer.brewery.state
                    : "Unknown"
            }</p>
        </div>
    );
}