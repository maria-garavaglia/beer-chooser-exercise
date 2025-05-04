import BeerView from './BeerView.js'
import {useState} from 'react';
import axios from 'axios';

export default function BeerListView({searchCriteria})
{
    const [beerList, setBeerList] = useState([
        {
            id: 0,
            name: "Test Beer",
            abv: 10.5,
            style: "Test Beer Style",
            description: "A beer used to test the Beer Chooser",
            brewery: 1234
        },
        {
            id: 1,
            name: "Test Beer 2",
            abv: 5.0,
            style: "Test Beer Style 2",
            description: "Another beer used to test the Beer Chooser",
            brewery: 5678
        }
    ]);

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

    return (
        <>
            <p>Showing {beerList.length} matching beers</p>
            <div>
            {
                beerList.map(beer => <BeerView beer={beer} />)
            }
            </div>
        </>
    );
}