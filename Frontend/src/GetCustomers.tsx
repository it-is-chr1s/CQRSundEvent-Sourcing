import {FormEvent, useState} from 'react';

export default function GetCustomers(){
    const [customers, setCustomers] = useState([]);

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
        }).then(response => response.json())
        .then(data => {
            setCustomers(data);
        }).catch(error => {
            console.error('Error fetching data:', error);
        });
    }

    return (
        <div className="w-1/3 flex flex-col items-center py-2 px-4 border-4 rounded-md m-4">
            <h2>Get Customers</h2>
            <form onSubmit={onFormSubmit} className="flex flex-col items-center">
                <label className="mb-2">
                    <span className='mr-2'>Name:</span>
                    <input type="text" name="name"/>
                </label>
                <button type="submit" className='bg-lime-500 hover:bg-lime-600 mb-2'>Load Customers</button>
            </form>
            <table className="w-full">
                <thead>
                    <tr>
                        <th>Username</th>
                        <th>Name</th>
                        <th>Address</th>
                        <th>Birthday</th>
                    </tr>
                </thead>
                <tbody>
                    {customers.map((customer) => (
                        <tr>
                            <td className="text-center">{customer.username}</td>
                            <td className="text-center">{customer.name}</td>
                            <td className="text-center">{customer.address}</td>
                            <td className="text-center">{new Date(customer.birthday).toLocaleDateString()}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}