import BeerView from './BeerView.js'

export default function BeerListView({beerList})
{
    return (
        <div>
        {
            beerList.map(beer => <BeerView beer={beer} />)
        }
        </div>
    );
}