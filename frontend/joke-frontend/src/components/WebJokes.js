import React, { useState } from 'react';
import './WebJokes.css'; // Import the CSS file

function WebJokes() {
  const [joke, setJoke] = useState('');
  console.log(process.env.REACT_APP_BACKEND_WEBSERVICE);
  const API_URL = process.env.REACT_APP_BACKEND_WEBSERVICE || 'http://localhost:8080';

  const fetchJoke = async () => {
    try {
      const response = await fetch(`${API_URL}/jokeme`); // Use the environment variable for the base URL
      const jokeText = await response.text(); // Use .text() instead of .json()
      setJoke(jokeText);
    } catch (error) {
      console.error('Error fetching joke:', error);
    }
  };

  return (
    <div className="webjokes-container">
      <button className="webjokes-button" onClick={fetchJoke}>Get a Joke</button>
      {joke && <p className="webjokes-joke">{joke}</p>}
    </div>
  );
}

export default WebJokes;
