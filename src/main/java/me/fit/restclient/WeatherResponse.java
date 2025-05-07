package me.fit.restclient;

import java.util.ArrayList;

import me.fit.restclient.Forecast;

public class WeatherResponse {

    public String city;
    public String temperature;
    public String wind;
    public String description;
    public ArrayList<Forecast> forecast;

    public WeatherResponse() {

    }

    public WeatherResponse(String temperature, String wind, String description, ArrayList<Forecast> forecast, String city) {
        this.temperature = temperature;
        this.wind = wind;
        this.description = description;
        this.forecast = forecast;
        this.city = city;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(ArrayList<Forecast> forecast) {
        this.forecast = forecast;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((temperature == null) ? 0 : temperature.hashCode());
        result = prime * result + ((wind == null) ? 0 : wind.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((forecast == null) ? 0 : forecast.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WeatherResponse other = (WeatherResponse) obj;
        if (temperature == null) {
            if (other.temperature != null)
                return false;
        } else if (!temperature.equals(other.temperature))
            return false;
        if (wind == null) {
            if (other.wind != null)
                return false;
        } else if (!wind.equals(other.wind))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (forecast == null) {
            if (other.forecast != null)
                return false;
        } else if (!forecast.equals(other.forecast))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "WeatherResponse [temperature=" + temperature + ", wind=" + wind + ", description=" + description
                + ", forecast=" + forecast + "]";
    }

}
