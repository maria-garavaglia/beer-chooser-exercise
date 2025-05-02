import './App.css';
import {useState} from 'react';
import axios from 'axios';

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
        console.log(filter);
        axios.get('http://localhost:8080/beers')
            .then(res => {
                const foundBeers = res.data;
                setBeerList(foundBeers);
            })
        ;
    }

    return (
        <div>
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
            <p>Showing {beerList.length} matching beers</p>
            <BeerListView beerList={beerList} />
        </div>
    );
}

function BeerListView({beerList})
{
    const beerViews = beerList.map(beer =>
        <div key={beer.id}>
            <p>
                ID: {beer.id}
                <br />
                Name: {beer.name}
                <br />
                ABV: {beer.abv}%
                <br />
                Style: {beer.style}
                <br />
                Description: {beer.description}
                <br />
                Brewery: {
                    beer.brewery
                        ? beer.brewery.name + ", "
                            + beer.brewery.city + ", "
                            + beer.brewery.state
                        : "Unknown"
                    }
            </p>
        </div>
    );

    return (
        <div>{beerViews}</div>
    );
}
