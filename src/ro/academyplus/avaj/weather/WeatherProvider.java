package ro.academyplus.avaj.weather;

import ro.academyplus.avaj.utils.Logger;

public class WeatherProvider {

    private static WeatherProvider  instance;

    private WeatherProvider() {
    }

    public static WeatherProvider getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        int weatherScore = (p_coordinates.getHeight() + 
          p_coordinates.getLatitude() + p_coordinates.getLongitude()) % 4;
        switch (weatherScore) {
            case 0 :
                return "RAIN";
            case 1 :
                return "FOG";
            case 2 :
                return "SUN";
            default:
                return "SNOW";
        }
    }
}