package ro.academyplus.avaj.aircraft;

import ro.academyplus.avaj.weather.Coordinates;

public class AircraftFactory {

    static private AircraftFactory  instance;
    private static long idCounter = 0;

    private AircraftFactory() {}

    public static AircraftFactory  getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        switch (p_type) {
            case "Helicopter" : return (new Helicopter(++idCounter, p_name, p_coordinates));
            case "Balloon" : return (new Balloon(++idCounter, p_name, p_coordinates));
            case "JetPlane" : return (new JetPlane(++idCounter, p_name, p_coordinates));
            default:
                throw new IllegalArgumentException("Unknown aircraft type: " + p_type); // replace by custom exception for bonus
        }
    }
}