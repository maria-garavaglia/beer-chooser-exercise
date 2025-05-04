export default function BeerListView({beer})
{
    return (
        <div key={beer.id}>
                <h3>{beer.name}</h3>
                <p>{beer.style} - {beer.abv}%
                <br />
                {
                    beer.brewery
                        ? beer.brewery.name + " - "
                            + beer.brewery.city + ", "
                            + beer.brewery.state
                        : "Unknown"
                }
                <br />
                {beer.description}
            </p>
        </div>
    );
}