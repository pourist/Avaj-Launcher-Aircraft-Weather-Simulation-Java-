package ro.academyplus.avaj.weather;

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
        return null; // implement later
    }
}