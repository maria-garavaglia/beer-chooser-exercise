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

    return (
        <div>
            <FilterForm />
            <BeerListView beerList={beerList} />
        </div>
    );
}

function FilterForm()
{
    const [filter, setFilter] = useState({
        name: "",
        style: "",
        abvMin: 0.0,
        abvMax: 100.0
    });

    function handleChangeName(e)
    {
        setFilter({
            ...filter,
            name: e.target.value
        });
    }

    function handleChangeStyle(e)
    {
        setFilter({
            ...filter,
            style: e.target.value
        });
    }

    function handleChangeAbvMin(e)
    {
        // TODO error checking
        setFilter({
            ...filter,
            abvMin: e.target.value
        });
    }

    function handleChangeAbvMax(e)
    {
        // TODO error checking
        setFilter({
            ...filter,
            abvMax: e.target.value
        });
    }

    function applyFilter(e)
    {
        // TODO query beer database
        console.log("Applying filter");
        console.log(filter);
    }

    return (
        <div>
            <div>
                Name:
                <input value={filter.name} onChange={handleChangeName} />
            </div>
            <div>
                Style:
                <input value={filter.style} onChange={handleChangeStyle} />
            </div>
            <div>
                ABV:
                <input value={filter.abvMin} onChange={handleChangeAbvMin} />
                -
                <input value={filter.abvMax} onChange={handleChangeAbvMax} />
            </div>
            <button onClick={applyFilter}>Apply</button>
        </div>
    );
}

function BeerListView({beerList})
{
    const beerViews = beerList.map(beer =>
        <div key={beer.id}>
            <p>
                {beer.name}
                <br />
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
