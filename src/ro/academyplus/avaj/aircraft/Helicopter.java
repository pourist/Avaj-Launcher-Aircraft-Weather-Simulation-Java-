package ro.academyplus.avaj.aircraft;

import ro.academyplus.avaj.utils.Logger;
import ro.academyplus.avaj.weather.Coordinates;

public class Helicopter extends Aircraft {

    private static final int MAX_HEIGHT = 100;

    private static final int SUN_LONGITUDE_INCREASE  = 10;
    private static final int SUN_HEIGHT_INCREASE     = 2;

    private static final int RAIN_LONGITUDE_INCREASE = 5;
    private static final int FOG_LONGITUDE_INCREASE  = 1;

    private static final int SNOW_HEIGHT_DECREASE    = 12;

    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);

        int longitude = coordinates.getLongitude();
        int latitude  = coordinates.getLatitude();
        int height    = coordinates.getHeight();

        switch (weather) {
            case "SUN":
                longitude += SUN_LONGITUDE_INCREASE;
                height = Math.min(MAX_HEIGHT, height + SUN_HEIGHT_INCREASE);
                Logger.log(this + ": This is hot.");
                break;

            case "RAIN":
                longitude += RAIN_LONGITUDE_INCREASE;
                Logger.log(this + ": It's raining. Better watch out for lightings.");
                break;

            case "FOG":
                longitude += FOG_LONGITUDE_INCREASE;
                Logger.log(this + ": Can't see anything.");
                break;

            case "SNOW":
                height -= SNOW_HEIGHT_DECREASE;
                Logger.log(this + ": My rotor is going to freeze!");
                if (height <= 0) {
                    Logger.log(this + " landing. height:");
                    weatherTower.unregisterAircraft(this);
                    return;
                }
                break;
        }

        coordinates = Coordinates.of(longitude, latitude, height);
    }

    @Override
    public String toString() {
        return "Helicopter#" + name + "(" + id + ")";
    }
}
