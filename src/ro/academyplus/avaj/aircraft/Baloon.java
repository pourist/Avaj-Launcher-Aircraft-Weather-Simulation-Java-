package ro.academyplus.avaj.aircraft;

import ro.academyplus.avaj.utils.Logger;
import ro.academyplus.avaj.weather.Coordinates;

public class Baloon extends Aircraft {

    private static final int MAX_HEIGHT = 100;

    private static final int SUN_LONGITUDE_INCREASE = 2;
    private static final int SUN_HEIGHT_INCREASE    = 4;

    private static final int RAIN_HEIGHT_DECREASE   = 5;
    private static final int FOG_HEIGHT_DECREASE    = 3;
    private static final int SNOW_HEIGHT_DECREASE   = 15;

    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
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
                Logger.log(this + ": Let's enjoy the good weather and take some pics.");
                break;

            case "RAIN":
                height -= RAIN_HEIGHT_DECREASE;
                if (height <= 0) {
                    Logger.log(this + " landing.");
                    weatherTower.unregisterAircraft(this);
                    return;
                }
                Logger.log(this + ": Damn you rain! You messed up my Baloon.");
                break;

            case "FOG":
                height -= FOG_HEIGHT_DECREASE;
                if (height <= 0) {
                    Logger.log(this + " landing.");
                    weatherTower.unregisterAircraft(this);
                    return;
                }
                Logger.log(this + ": Can't see anything.");
                break;

            case "SNOW":
                height -= SNOW_HEIGHT_DECREASE;
                if (height <= 0) {
                    Logger.log(this + " landing.");
                    weatherTower.unregisterAircraft(this);
                    return;
                }
                Logger.log(this + ": It's snowing. We're gonna crash.");
                break;
        }

        coordinates = Coordinates.of(longitude, latitude, height);
    }

    @Override
    public String toString() {
        return "Baloon#" + name + "(" + id + ")";
    }
}
