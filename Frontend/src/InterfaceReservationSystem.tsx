import Write from './Write';
import Read from './Read';
import SpecialFunctions from './SpecialFunctions';

export default function InterfaceReservationSystem(){
    return (
        <div>
            <h1>Reservation System</h1>
            <Write></Write>
            <Read></Read>
            <SpecialFunctions></SpecialFunctions>
        </div>
    );
}