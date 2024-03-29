import {FormEvent, useState} from 'react';

export default function GetFreeRooms(){
    const [rooms, setRooms] = useState([]);

    function onFormSubmit(event: FormEvent<HTMLFormElement>){
        event.preventDefault();

        const form = event.currentTarget;
        const data = new FormData(form);

        const startDateString = data.get('startDate');
        const endDateString = data.get('endDate');
        const persons = data.get('persons');

        const startDateMillis = new Date(startDateString as string).getTime();
        const endDateMillis = new Date(endDateString as string).getTime();

        const params = new URLSearchParams();
        params.append('startDate', startDateMillis.toString());
        params.append('endDate', endDateMillis.toString());
        params.append('persons', persons.toString());

        const url = `http://localhost:8085/getFreeRooms?${params.toString()}`;
        console.log(url);

        fetch(url, {
            method: 'POST',
        }).then(response => response.json())
        .then(data => {
            setRooms(data);
        }).catch(error => {
            console.error('Error fetching data:', error);
        });
    }

    return (
        <div className="w-1/3 flex flex-col items-center py-2 px-4 border-4 rounded-md my-4">
            <h2>Get Free Rooms</h2>
            <form onSubmit={onFormSubmit} className="flex flex-col items-center">
                <div className="mb-2">
                    <label className="mr-5">
                        <span className='mr-2'>Start Date:</span>
                        <input type="date" name="startDate" required/>
                    </label>
                    <label className="mr-5">
                        <span className='mr-2'>End Date:</span>
                        <input type="date" name="endDate" required/>
                    </label>
                </div>
                <label className="mb-2">
                        <span className='mr-2'>Persons:</span>
                        <input type="number" name="persons" required/>
                    </label>
                <button type="submit" className='bg-lime-500 hover:bg-lime-600 mb-2'>Load Free Rooms</button>
            </form>
            <table className="w-full">
                <thead>
                    <tr>
                        <th>Room<br></br>Number</th>
                        <th>Number<br></br>of Beds</th>
                        <th>Bath</th>
                    </tr>
                </thead>
                <tbody>
                    {rooms.map((room) => (
                        <tr>
                            <td className="text-center">{room.number}</td>
                            <td className="text-center">{room.numberOfBeds}</td>
                            <td className="text-center">{(room.bath) ? "yes" : "no"}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}