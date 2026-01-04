package ro.academyplus.avaj.exceptions;

public class UnknownAircraftTypeException extends InvalidScenarioException {

    public UnknownAircraftTypeException(String type) {
        super("Unknown aircraft type: " + type);
    }
}
