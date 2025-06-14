import { useEffect, useState } from "react";

function WeatherCard({ city }) {
  const [weather, setWeather] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    async function fetchWeather() {
      try {
        const url = `http://localhost:8080/api/v1/weather/${city}`; // ✅ Added `const` for the `url` variable
        const response = await fetch(url);

        if (!response.ok) {
          console.error("Server error:", response.status);
          setLoading(false);
          return;
        }

        const data = await response.json();
        console.log("Weather data:", data);

        const conditionText = data.current.weather_descriptions?.[0]?.toLowerCase() || ""; // ✅ Added optional chaining and fallback to avoid errors

        let weatherClass = "default";
        if (conditionText.includes("sunny") || conditionText.includes("clear")) {
          weatherClass = "sunny";
        } else if (conditionText.includes("cloud")) {
          weatherClass = "cloudy";
        } else if (conditionText.includes("rain") || conditionText.includes("drizzle")) {
          weatherClass = "rainy";
        } else if (conditionText.includes("thunder")) {
          weatherClass = "thunderstorm";
        } else if (conditionText.includes("snow")) {
          weatherClass = "snowy";
        } else if (conditionText.includes("night")) {
          weatherClass = "night";
        }

        document.body.className = weatherClass;

        setWeather({
          location: `${data.location.name}, ${data.location.country}`,
          time: data.location.localtime,
          temperature: data.current.temperature,
          condition: data.current.weather_descriptions?.[0], // ✅ Optional chaining to avoid crashes
          iconUrl: data.current.weather_icons?.[0],          // ✅ Optional chaining to avoid crashes
          humidity: data.current.humidity,
          windSpeed: data.current.wind_speed,
        });

        setLoading(false);
      } catch (error) {
        console.error("Failed to fetch weather:", error);
        setLoading(false);
      }
    }

    if (city) {
      fetchWeather(); // ✅ Only fetch if `city` is provided
    }

    return () => {
      document.body.className = "default";
    };
  }, [city]); // ✅ Added `city` as a dependency so it re-runs when the city changes

  if (loading)
    return <div className="weather-card">Loading weather data...</div>;

  if (!weather)
    return (
      <div className="weather-card">
        Failed to load weather data. Please try again.
      </div>
    );

  return (
    <div className="weather-card">
      <div className="location">{weather.location}</div>
      <div className="time">Local Time: {weather.time}</div>

      <div className="weather-icon">
        <img src={weather.iconUrl} alt={weather.condition} />
      </div>
      <div className="description">{weather.condition}</div>

      <div className="weather-details">
        <div className="detail">
          <div className="detail-label">Temperature</div>
          <div className="detail-value">{weather.temperature}°C</div>
        </div>
        <div className="detail">
          <div className="detail-label">Wind</div>
          <div className="detail-value">{weather.windSpeed} km/h</div>
        </div>
        <div className="detail">
          <div className="detail-label">Humidity</div>
          <div className="detail-value">{weather.humidity}%</div>
        </div>
      </div>
    </div>
  );
}

export default WeatherCard;