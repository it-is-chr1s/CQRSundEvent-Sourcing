export default function CancelBooking(){
    return (
        <div>
            <h2>Cancel Booking</h2>
            <form>
                <label>
                    <span>Reservation Number:</span>
                    <input type="number" name="reservationNumber" required/>
                </label>
                <button type="submit">Cancel Booking</button>
            </form>
        </div>
    );
}