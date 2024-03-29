import {FormEvent} from 'react';

export default function GetFreeRooms(){
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
        }).then(response => {
            console.log(response.json());
        })
    }

    return (
        <div>
            <h2>Get Free Rooms</h2>
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
                    <span>Persons:</span>
                    <input type="number" name="persons" required/>
                </label>
                <button type="submit">Load Free Rooms</button>
            </form>
        </div>
    );
}