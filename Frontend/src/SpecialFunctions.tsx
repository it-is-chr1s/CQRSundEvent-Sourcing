export default function SpecialFunctions(){
    function initializeDatabase(){
        fetch('http://localhost:8081/initializeDatabase', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
        }).then(response => {
            console.log(response);
        })
    }

    return (
        <div>
            <div>
                <h2>Special Functions</h2>
                <button>Reload Query-Models</button>
                <button>Reload Events On Frontend</button>
                <button onClick={initializeDatabase} >Initialize Database</button>
            </div>
            <ul></ul>
        </div>
    );
}