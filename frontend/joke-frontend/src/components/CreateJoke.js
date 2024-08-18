import React, { useState } from 'react';
import './CreateJoke.css'; // Import CSS for styling

function CreateJoke() {
  const [setup, setSetup] = useState('');
  const [punchLine, setPunchLine] = useState('');
  const [type, setType] = useState('');

  const handleSubmit = async (event) => {
    event.preventDefault(); // Prevent the default form submission behavior

    const joke = { setup, punchLine, type };

    const API_URL = process.env.REACT_APP_BACKEND_DBSERVICE || 'http://localhost:8081'
    try {
      const response = await fetch(`${API_URL}/createJoke`, { // Replace with your microservice API URL
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(joke),
      });

      if (response.ok) {
        alert('Joke created successfully!');
        setSetup('');
        setPunchLine('');
        setType('');
      } else {
        alert('Failed to create joke. Please try again.');
      }
    } catch (error) {
      console.error('Error creating joke:', error);
    }
  };

  return (
    <div className="create-joke-container">
      <h2>Create a Joke</h2>
      <form onSubmit={handleSubmit} className="create-joke-form">
        <div className="form-group">
          <label htmlFor="setup">Setup:</label>
          <input
            type="text"
            id="setup"
            value={setup}
            onChange={(e) => setSetup(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="punchLine">Punchline:</label>
          <input
            type="text"
            id="punchLine"
            value={punchLine}
            onChange={(e) => setPunchLine(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="type">Type:</label>
          <input
            type="text"
            id="type"
            value={type}
            onChange={(e) => setType(e.target.value)}
            required
          />
        </div>
        <button type="submit" className="create-joke-button">Submit</button>
      </form>
    </div>
  );
}

export default CreateJoke;
