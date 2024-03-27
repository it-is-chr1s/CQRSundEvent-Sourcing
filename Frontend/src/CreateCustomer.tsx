import {FormEvent} from 'react';

export default function CreateCustomer(){
    function onFormSubmit(event: FormEvent<HTMLFormElement>){
        event.preventDefault();

        const form = event.currentTarget;
        const data = new FormData(form);

        const birthdayString = data.get('birthday');

        const birthdayMillis = new Date(birthdayString as string).getTime();
        
        const formDataJson = {
            eventType: "CREATE_CUSTOMER_EVENT",
            username: data.get('username'),
            name: data.get('name'),
            address: data.get('address'),
            birthday: birthdayMillis
        };
        console.log(formDataJson);
        fetch('http://localhost:8081/createCustomer', {
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
            <h2>Create Customer</h2>
            <form onSubmit={onFormSubmit}>
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
                    <input type="date" name="birthday" required/>
                </label>
                <button type="submit">Create Customer</button>
            </form>
        </div>
    );
}