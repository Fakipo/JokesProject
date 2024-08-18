import React, { useState } from 'react';
import './UserJokes.css'; // Import the CSS file

function UserJokes() {
    const [joke, setJoke] = useState('');
    const API_URL = process.env.REACT_APP_BACKEND_DBSERVICE || 'http://localhost:8081'; // Default to localhost for development

    const fetchJoke = async () => {
        try {
            const response = await fetch(`${API_URL}/getJoke`); // Use the environment variable for the base URL
            const jokeData = await response.json(); // Use .json() to parse JSON response
            setJoke(`${jokeData.setup} ... ${jokeData.punchLine}`); // Format the joke
        } catch (error) {
            console.error('Error fetching joke:', error);
        }
    };

    return (
        <div className="userjokes-container">
            <button className="userjokes-button" onClick={fetchJoke}>Get a Joke</button>
            {joke && <p className="userjokes-joke">{joke}</p>}
        </div>
    );
}

export default UserJokes;
