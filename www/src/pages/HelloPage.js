import React, { useEffect, useState } from "react";

const HelloPage = () => {
  const [message, setMessage] = useState("");
  useEffect(() => {
    fetch("/api/hello")
      .then((response) => response.text())
      .then((message) => {
        setMessage(message);
      });
  }, []);
  return (
    <div>
      <header className="App-header">
        <h1 className="App-title">{message}</h1>
      </header>
    </div>
  );
};

export default HelloPage;
