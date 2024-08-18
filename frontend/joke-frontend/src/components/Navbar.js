import React, { useState } from 'react';
import WebJokes from './WebJokes';
import UserJokes from './UserJokes';
import CreateJoke from './CreateJoke';
import './Navbar.css';

function Navbar() {
  const [currentPage, setCurrentPage] = useState('webjokes');

  const renderPage = () => {
    switch (currentPage) {
      case 'webjokes':
        return <WebJokes />;
      case 'userjoke':
        return <UserJokes />;
      case 'createjoke':
        return <CreateJoke />;
      default:
        return <WebJokes />;
    }
  };

  return (
    <div>
      <nav className="navbar">
        <ul className="navbar-menu">
          <li className="navbar-item" onClick={() => setCurrentPage('webjokes')}>Web Jokes</li>
          <li className="navbar-item" onClick={() => setCurrentPage('userjoke')}>User Jokes</li>
          <li className="navbar-item" onClick={() => setCurrentPage('createjoke')}>Create a Joke</li>
        </ul>
      </nav>
      {renderPage()}
    </div>
  );
}

export default Navbar;
