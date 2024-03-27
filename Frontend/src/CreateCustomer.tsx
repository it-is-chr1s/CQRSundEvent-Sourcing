export default function CreateCustomer(){
    return (
        <div>
            <h2>Create Customer</h2>
            <form>
                <label>
                    <span>Username:</span>
                    <input type="text" name="username" required/>
                </label>
                <label>
                    <span>Name:</span>
                    <input type="text" name="name" required/>
                </label>
                <label>
                    <span>Address:</span>
                    <input type="text" name="address" required/>
                </label>
                <label>
                    <span>Birthday:</span>
                    <input type="text" name="birthday" required/>
                </label>
            </form>
        </div>
    );
}