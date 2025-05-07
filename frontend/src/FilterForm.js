import './FilterForm.css';
import {useState} from 'react';

export default function FilterForm({searchCriteria, applyNewFilter})
{
    const [pendingSearch, setPendingSearch] = useState(searchCriteria);

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
        // TODO error checking
        setPendingSearch({
            ...pendingSearch,
            abvMin: e.target.value
        });
    }

    function handleChangeAbvMax(e)
    {
        // TODO error checking
        setPendingSearch({
            ...pendingSearch,
            abvMax: e.target.value
        });
    }

    return (
        <div class="filter-form-wrapper">
            <div class="filter-field">
                Name: <br />
                <input class="text-input" value={pendingSearch.name} onChange={handleChangeName} />
            </div>
            <div class="filter-field">
                Style: <br />
                <input class="text-input" value={pendingSearch.style} onChange={handleChangeStyle} />
            </div>
            <div class="filter-field">
                ABV: <br />
                <input class="abv-input" value={pendingSearch.abvMin} onChange={handleChangeAbvMin} /> - <input class="abv-input" value={pendingSearch.abvMax} onChange={handleChangeAbvMax} /> %
            </div>
            <button  class="filter-field" onClick={() => applyNewFilter(pendingSearch)}>Apply</button>
        </div>
    );
}