import {FormEvent} from 'react';

export default function GetCustomers(){
    function onFormSubmit(event: FormEvent<HTMLFormElement>){
        event.preventDefault();

        const form = event.currentTarget;
        const data = new FormData(form);

        const name = data.get('name');

        const params = new URLSearchParams();
        params.append('name', name as string);

        const url = `http://localhost:8084/getCustomers?${params.toString()}`;
        console.log(url);

        fetch(url, {
            method: 'POST',
        }).then(response => {
            console.log(response.json());
        })
    }

    return (
        <div>
            <h2>Get Customers:</h2>
            <form onSubmit={onFormSubmit}>
                <label>
                    <span>Name:</span>
                    <input type="text" name="name"/>
                </label>
                <button type="submit">Load Customers</button>
            </form>
        </div>
    );
}