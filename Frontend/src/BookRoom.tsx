import {FormEvent} from 'react';

export default function BookRoom(){
    function onFormSubmit(event: FormEvent<HTMLFormElement>){
        event.preventDefault();

        const form = event.currentTarget;
        const data = new FormData(form);

        const startDateString = data.get('startDate');
        const endDateString = data.get('endDate');

        const startDateMillis = new Date(startDateString as string).getTime();
        const endDateMillis = new Date(endDateString as string).getTime();
        
        const formDataJson = {
            eventType: "BOOK_ROOM_EVENT",
            startDate: startDateMillis,
            endDate: endDateMillis,
            roomNumber: data.get('roomNumber'),
            customer: data.get('customer')
        };
        console.log(formDataJson);
        fetch('http://localhost:8081/bookRoom', {
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
            <h2>Book Room</h2>
            <form onSubmit={onFormSubmit}>
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