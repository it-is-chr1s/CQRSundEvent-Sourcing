export default function GetBookings(){
    return (
        <div>
            <h2>Get Bookings</h2>
            <form>
                <label>
                    <span>Start Date:</span>
                    <input type="date" name="startDate" required/>
                </label>
                <label>
                    <span>End Date:</span>
                    <input type="date" name="endDate" required/>
                </label>
                <button type="submit">Load Bookings</button>
            </form>
        </div>
    );
}