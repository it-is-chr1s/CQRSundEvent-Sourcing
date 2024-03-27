export default function GetFreeRooms(){
    return (
        <div>
            <h2>Get Free Rooms</h2>
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
                    <span>Persons:</span>
                    <input type="number" name="persons" required/>
                </label>
                <button type="submit">Load Free Rooms</button>
            </form>
        </div>
    );
}