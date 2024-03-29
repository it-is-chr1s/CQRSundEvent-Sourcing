import {useState, useEffect} from "react";

export default function SpecialFunctions(){
    const [events, setEvents] = useState([]);

    function initializeDatabase(){
        fetch('http://localhost:8081/initializeDatabase', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
        }).then(response => {
            window.alert('Database initialized');
            console.log(response);
        })
    }

    function reloadEventsFrontend(){
        fetch('http://localhost:8080/getEvents', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
        }).then(response => response.json())
        .then(data => {
            setEvents(data);
        }).catch(error => {
            console.error('Error fetching data:', error);
        
        })
    }

    function reloadQueryModels(){
        fetch('http://localhost:8080/reloadQueryModels', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
        }).then(response => {
            window.alert('Query Models reloaded');
            console.log(response);
        })
    }

    let key = 0;

    return (
        <div className="py-2 px-4">
            <div className="mb-4">
                <h2>Special Functions</h2>
                <button className="mr-5" onClick={reloadQueryModels}>Reload Query-Models</button>
                <button className="mr-5" onClick={reloadEventsFrontend}>Reload Events On Frontend</button>
                <button className="mr-5" onClick={initializeDatabase} >Initialize Database</button>
            </div>
            <ul>
                {(events.length==0) ? "" : events.map((event) => (
                    <li key={key++}>{JSON.stringify(event)}</li>
                ))}
            </ul>
        </div>
    );
}