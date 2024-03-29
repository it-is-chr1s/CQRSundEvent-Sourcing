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
        <div className="py-2 px-4">
            <h2>Create Customer</h2>
            <form onSubmit={onFormSubmit}>
                <label className="mr-5">
                    <span className='mr-2'>Username:</span>
                    <input type="text" name="username" required/>
                </label>
                <label className="mr-5">
                    <span className='mr-2'>Name:</span>
                    <input type="text" name="name" required/>
                </label>
                <label className="mr-5">
                    <span className='mr-2'>Address:</span>
                    <input type="text" name="address" required/>
                </label>
                <label className="mr-5">
                    <span className='mr-2'>Birthday:</span>
                    <input type="date" name="birthday" required/>
                </label>
                <button type="submit" className='bg-lime-500 hover:bg-lime-600'>Create Customer</button>
            </form>
        </div>
    );
}