import BeerView from './BeerView.js'
import {useState} from 'react';
import axios from 'axios';

export default function BeerListView({searchCriteria})
{
    const [currentSearch, setCurrentSearch] = useState(null);
    const [beerList, setBeerList] = useState(null);
    const [error, setError] = useState(false);

    const axiosInstance = axios.create({
        baseURL: "http://localhost:8080/",
        timeout: 3000
    });

    if (currentSearch != searchCriteria)
    {
        setCurrentSearch(searchCriteria);
        axiosInstance.get(
            'beers/search',
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
                setError(false);
            }
        ).catch(
            function (error)
            {
                if (error.response)
                {
                    // Request made, server responded with something outside 2xx
                    console.log(error.response.data);
                    console.log(error.response.status);
                    console.log(error.response.headers);
                }
                else if (error.request)
                {
                    // Request made, no response
                    console.log(error.request);
                }
                else
                {
                    // Something happened in setting up the request
                    console.log('Error', error.message);
                }
                console.log(error.config);
                setError(true);
            }
        );
    }

    if (error)
    {
        return <p style={{color: "red"}}>Error encountered while loading beer list</p>;
    }
    else if (beerList === null)
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