import {useState} from 'react';

export default function FilterForm({searchCriteria, onApply})
{
    const [pendingSearch, setPendingSearch] = useState({searchCriteria});

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
        <div>
            <div>
                Name:
                <input value={pendingSearch.name} onChange={handleChangeName} />
            </div>
            <div>
                Style:
                <input value={pendingSearch.style} onChange={handleChangeStyle} />
            </div>
            <div>
                ABV:
                <input value={pendingSearch.abvMin} onChange={handleChangeAbvMin} />
                -
                <input value={pendingSearch.abvMax} onChange={handleChangeAbvMax} />
            </div>
            <button onClick={() => onApply(pendingSearch)}>Apply</button>
        </div>
    );
}