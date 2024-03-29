import GetBookings from './GetBookings';
import GetFreeRooms from './GetFreeRooms';
import GetCustomers from './GetCustomers';

export default function Read(){
    return (
        <div className="flex flex-row">
            <GetBookings></GetBookings>
            <GetFreeRooms></GetFreeRooms>
            <GetCustomers></GetCustomers>
        </div>
    )
}