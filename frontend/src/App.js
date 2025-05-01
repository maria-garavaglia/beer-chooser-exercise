import './App.css';
//import axios from 'axios';

export default function App()
{
    function applyFilter()
    {
        console.log("Applying filter");
    }

    return (
        <div>
            <FilterForm action={applyFilter} />
        </div>
    );
}

function FilterForm({action})
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
