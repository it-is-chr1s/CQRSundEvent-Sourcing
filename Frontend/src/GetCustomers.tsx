export default function GetCustomers(){
    return (
        <div>
            <h2>Get Customers:</h2>
            <form>
                <label>
                    <span>Name:</span>
                    <input type="text" name="name"/>
                </label>
                <button type="submit">Load Customers</button>
            </form>
        </div>
    );
}