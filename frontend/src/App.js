import './App.css';
import {useState} from 'react';
//import axios from 'axios';

export default function App()
{
    const [beerList, setBeerList] = useState([
        {
            id: 0,
            name: "Test Beer",
            abv: 10.5,
            style: "Test Beer Style",
            description: "A beer used to test the Beer Chooser",
            brewery: 1234
        }
    ]);

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
        <div>
            <p>
                <h3>{beer.name}</h3>
                {beer.abv}% - {beer.brewery}
                <br />
                {beer.style}
                <br />
                {beer.description}
            </p>
        </div>
    );

    return (
        <div>{beerViews}</div>
    );
}
