import './SearchForm.css';
import {useState} from 'react';

export default function SearchForm({activeSearch, setActiveSearch})
{
    const [pendingSearch, setPendingSearch] = useState(activeSearch);

    function handleChangeName(e)
    {
        setPendingSearch({
            ...pendingSearch,
            name: e.target.value
        });
    }

    function handleChangeStyle(e)
    {
        setPendingSearch({
            ...pendingSearch,
            style: e.target.value
        });
    }

    function handleChangeAbvMin(e)
    {
        setPendingSearch({
            ...pendingSearch,
            abvMin: e.target.value
        });
    }

    function handleChangeAbvMax(e)
    {
        setPendingSearch({
            ...pendingSearch,
            abvMax: e.target.value
        });
    }

    return (
        <div className="filter-form-wrapper">
            <div className="filter-field">
                Name: <br />
                <input className="text-input" value={pendingSearch.name} onChange={handleChangeName} />
            </div>
            <div className="filter-field">
                Style: <br />
                <input className="text-input" value={pendingSearch.style} onChange={handleChangeStyle} />
            </div>
            <div className="filter-field">
                ABV: <br />
                <input
                    className="abv-input"
                    type="number"
                    min="0"
                    max="100"
                    value={pendingSearch.abvMin}
                    onChange={handleChangeAbvMin}
                />
                &nbsp;-&nbsp;
                <input
                    className="abv-input"
                    type="number"
                    min="0"
                    max="100"
                    value={pendingSearch.abvMax}
                    onChange={handleChangeAbvMax}
                /> %
            </div>
            <button className="filter-field" onClick={() => setActiveSearch(pendingSearch)}>Search</button>
        </div>
    );
}