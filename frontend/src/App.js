import './App.css';
import BeerListView from './BeerListView.js';
import SearchForm from './SearchForm.js';
import {useState} from 'react';

export default function App()
{
    // active search defined here so both FilterForm and BeerListView can see it
    const [search, setSearch] = useState({
        name: "",
        style: "",
        abvMin: 0.0,
        abvMax: 100.0
    });

    return (
        <div>
            <div className="filter-sidebar">
                <SearchForm activeSearch={search} setActiveSearch={setSearch} />
            </div>
            <div className="main-content">
                <BeerListView searchCriteria={search} />
            </div>
        </div>
    );
}
