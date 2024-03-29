import {FormEvent} from 'react';

export default function CancelBooking(){
    function onFormSubmit(event: FormEvent<HTMLFormElement>){
        event.preventDefault();

        const form = event.currentTarget;
        const data = new FormData(form);

        const formDataJson = {
            eventType: "CANCEL_BOOKING_EVENT",
            reservationNumber: data.get('reservationNumber')
        }

        console.log(formDataJson);
        fetch('http://localhost:8081/cancelBooking', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formDataJson),
        }).then(response => {
            console.log(response);
        })
    }

    return (
        <div className="py-2 px-4">
            <h2>Cancel Booking</h2>
            <form onSubmit={onFormSubmit} className="flex">
                <label className="mr-5">
                    <span className='mr-2'>Reservation Number:</span>
                    <input type="number" name="reservationNumber" required/>
                </label>
                <button type="submit" className='bg-lime-500 hover:bg-lime-600'>Cancel Booking</button>
            </form>
        </div>
    );
}