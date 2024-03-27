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
        <div>
            <h2>Cancel Booking</h2>
            <form onSubmit={onFormSubmit}>
                <label>
                    <span>Reservation Number:</span>
                    <input type="number" name="reservationNumber" required/>
                </label>
                <button type="submit">Cancel Booking</button>
            </form>
        </div>
    );
}