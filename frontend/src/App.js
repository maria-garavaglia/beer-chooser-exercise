import './App.css';
import {useState} from 'react';
//import axios from 'axios';

export default function App()
{
    const [beerList, setBeerList] = useState(null);

    function applyFilter()
    {
        console.log("Applying filter");
    }

    return (
        <div>
            <FilterForm action={applyFilter} />
            <BeerListView beerList={beerList} />
        </div>
    );
}

function FilterForm({action, beerList})
{
    return (
        <form action={action}>
            <div>
                Name:
                <input name="nameInput" />
            </div>
            <div>
                Style:
                <input name="styleInput" />
            </div>
            <div>
                ABV:
                <input name="abvMinInput" />
                -
                <input name="abvMaxInput" />
            </div>
            <button type="submit">Apply</button>
        </form>
    );
}

function BeerListView({beerList})
{
    const beerViews = beerList.map(beer =>
        <li key={beer.id}>
            {beer.name}
        </li>
    );

    return (
        <ul>{beerViews}</ul>
    );
}
