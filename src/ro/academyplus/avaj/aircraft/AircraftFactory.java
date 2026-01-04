package ro.academyplus.avaj.aircraft;

import ro.academyplus.avaj.exceptions.UnknownAircraftTypeException;
import ro.academyplus.avaj.weather.Coordinates;

public class AircraftFactory {

    private static AircraftFactory instance;
    private static long idCounter = 0;

    private AircraftFactory() {}

    public static AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

    public Flyable newAircraft(String type, String name, Coordinates coordinates)
            throws UnknownAircraftTypeException {
        switch (type) {
            case "Helicopter":
                return new Helicopter(++idCounter, name, coordinates);
            case "Baloon":
                return new Baloon(++idCounter, name, coordinates);
            case "JetPlane":
                return new JetPlane(++idCounter, name, coordinates);
            default:
                throw new UnknownAircraftTypeException(type);
        }
    }
}
