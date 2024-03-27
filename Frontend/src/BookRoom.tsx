export default function BookRoom(){
    return (
        <div>
            <h2>Book Room</h2>
            <form>
                <label>
                    <span>Start Date:</span>
                    <input type="date" name="startDate" required/>
                </label>
                <label>
                    <span>End Date:</span>
                    <input type="date" name="endDate" required/>
                </label>
                <label>
                    <span>Room Number:</span>
                    <input type="number" name="roomNumber" required/>
                </label>
                <label>
                    <span>Customer:</span>
                    <input type="text" name="customer" required/>
                </label>
                <button type="submit">Book Room</button>
            </form>
        </div>
    );
}