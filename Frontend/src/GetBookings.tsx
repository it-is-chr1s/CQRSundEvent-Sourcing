import {FormEvent, useState} from 'react';

export default function GetBookings(){
    const [bookings, setBookings] = useState([]);

    function onFormSubmit(event: FormEvent<HTMLFormElement>){
        event.preventDefault();

        const form = event.currentTarget;
        const data = new FormData(form);

        const startDateString = data.get('startDate');
        const endDateString = data.get('endDate');

        const startDateMillis = new Date(startDateString as string).getTime();
        const endDateMillis = new Date(endDateString as string).getTime();

        const params = new URLSearchParams();
        params.append('startDate', startDateMillis.toString());
        params.append('endDate', endDateMillis.toString());

        const url = `http://localhost:8083/getBookings?${params.toString()}`;
        console.log(url);

        fetch(url, {
            method: 'POST',
        }).then(response => response.json())
        .then(data => {
            setBookings(data);
        }).catch(error => {
            console.error('Error fetching data:', error);
        
        })
    }

    return (
        <div className="w-1/3 flex flex-col items-center py-2 px-4 border-4 rounded-md m-4">
            <h2>Get Bookings</h2>
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
                <button type="submit" className='bg-lime-500 hover:bg-lime-600 mb-2'>Load Bookings</button>
                <table className="w-full">
                    <thead>
                        <tr>
                            <th>Reservation<br></br>Number</th>
                            <th>Room<br></br>Number</th>
                            <th>Start<br/>Date</th>
                            <th>End<br/>Date</th>
                            <th>Customer</th>
                        </tr>
                    </thead>
                    <tbody>
                        {bookings.map((booking) => (
                            <tr>
                                <td className="text-center">{booking.reservationNumber}</td>
                                <td className="text-center">{booking.roomNumber}</td>
                                <td className="text-center">{new Date(booking.startDate).toLocaleDateString()}</td>
                                <td className="text-center">{new Date(booking.endDate).toLocaleDateString()}</td>
                                <td className="text-center">{booking.customer}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </form>
        </div>
    );
}