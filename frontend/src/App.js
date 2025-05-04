import './App.css';
import BeerListView from './BeerListView.js';
import FilterForm from './FilterForm.js';
import {useState} from 'react';

export default function App()
{

    const [filter, setFilter] = useState({
        name: "",
        style: "",
        abvMin: 0.0,
        abvMax: 100.0
    });

    return (
        <div>
            <FilterForm searchCriteria={filter} onApply={setFilter} />
            <BeerListView searchCriteria={filter} />
        </div>
    );
}
