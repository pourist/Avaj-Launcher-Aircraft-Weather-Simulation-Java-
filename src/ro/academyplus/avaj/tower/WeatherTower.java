package ro.academyplus.avaj.tower;

import ro.academyplus.avaj.aircraft.Flyable;
import ro.academyplus.avaj.utils.Logger;
import ro.academyplus.avaj.weather.Coordinates;
import ro.academyplus.avaj.weather.WeatherProvider;


public class WeatherTower extends Tower {

    public void registerAircraft(Flyable p_flyable) {
        super.register(p_flyable);
        Logger.log("Tower says: " + p_flyable.toString() + 
         " registered to weather tower.");
    }

    public void unregisterAircraft(Flyable p_flyable) {
        super.unregister(p_flyable);
        Logger.log("Tower says: " + p_flyable.toString() + 
         " unregistered from weather tower.");
    }

    public String getWeather(Coordinates p_coordinates) {
        return WeatherProvider.getInstance()
                .getCurrentWeather(p_coordinates);
    }

    public void changeWeather() {
        super.conditionChanged();
    }
}