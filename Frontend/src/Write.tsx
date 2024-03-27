import BookRoom from './BookRoom';
import CancelBooking from './CancelBooking';
import CreateCustomer from './CreateCustomer';

export default function Write(){
    return (
        <div>
            <BookRoom></BookRoom>
            <CancelBooking></CancelBooking>
            <CreateCustomer></CreateCustomer>
        </div>
    )
}