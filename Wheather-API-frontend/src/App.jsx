import './App.css'
import { useState } from "react";
import SearchBar from "./component/SearchBar";
import WeatherCard from "./component/WeatherCard";

function App() {
  const [city, setCity] = useState("New York");

  return (
    <div className="app">
      <SearchBar onSearch={setCity} />
      <WeatherCard city={city} />
    </div>
  );
}

export default App;