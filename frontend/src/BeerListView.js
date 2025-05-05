import BeerView from './BeerView.js'
import {useState} from 'react';
import axios from 'axios';

export default function BeerListView({searchCriteria})
{
    const [currentFilter, setCurrentFilter] = useState(null);
    const [beerList, setBeerList] = useState(null);

    if (currentFilter != searchCriteria)
    {
        setCurrentFilter(searchCriteria);
        axios.get(
            'http://localhost:8080/beers/search',
            {
                params: {
                    name: searchCriteria.name,
                    style: searchCriteria.style,
                    abvMin: searchCriteria.abvMin,
                    abvMax: searchCriteria.abvMax
                }
            }
        ).then(
            res => {
                const foundBeers = res.data;
                setBeerList(foundBeers);
            })
        ;
    }

    if (beerList === null)
    {
        return <p>Loading...</p>;
    }
    else
    {
        return (
            <>
                <p>Showing {beerList.length} matching beers</p>
                <div>
                {
                    beerList.map(beer => <BeerView key={beer.id} beer={beer} />)
                }
                </div>
            </>
        );
    }
}