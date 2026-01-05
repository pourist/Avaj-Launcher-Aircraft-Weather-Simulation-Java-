package ro.academyplus.avaj.simulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import ro.academyplus.avaj.aircraft.AircraftFactory;
import ro.academyplus.avaj.aircraft.Flyable;
import ro.academyplus.avaj.exceptions.InvalidAircraftDataException;
import ro.academyplus.avaj.exceptions.InvalidScenarioException;
import ro.academyplus.avaj.exceptions.InvalidSimulationCountException;
import ro.academyplus.avaj.tower.WeatherTower;
import ro.academyplus.avaj.utils.Logger;
import ro.academyplus.avaj.weather.Coordinates;

public class Simulator {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Simulator <scenario_file>");
            System.exit(1);
        }

        try {
            Logger.init("simulation.txt");
            runSimulation(args[0]);
            Logger.close();
        } catch (InvalidScenarioException | IOException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }

    private static void runSimulation(String scenarioFile)
            throws IOException, InvalidScenarioException {

        BufferedReader reader = new BufferedReader(new FileReader(scenarioFile));

        int simulations;
        try {
            simulations = Integer.parseInt(reader.readLine());
            if (simulations < 0)
                throw new NumberFormatException();
        } catch (Exception e) {
            reader.close();
            throw new InvalidSimulationCountException(
                    "First line must be a positive integer");
        }

        WeatherTower weatherTower = new WeatherTower();
        AircraftFactory factory = AircraftFactory.getInstance();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            if (parts.length != 5) {
                reader.close();
                throw new InvalidAircraftDataException(
                        "Invalid scenario line: " + line);
            }

            int longitude;
            int latitude;
            int height;

            try {
                longitude = Integer.parseInt(parts[2]);
                latitude  = Integer.parseInt(parts[3]);
                height    = Integer.parseInt(parts[4]);
            } catch (NumberFormatException e) {
                reader.close();
                throw new InvalidAircraftDataException(
                        "Invalid coordinate values: " + line);
            }

            if (longitude < 0 || latitude < 0 || height < 0) {
                reader.close();
                throw new InvalidAircraftDataException(
                        "Invalid coordinates: " + line);
            }

            Coordinates coordinates =
                    Coordinates.of(longitude, latitude, height);

            Flyable aircraft =
                    factory.newAircraft(parts[0], parts[1], coordinates);
            aircraft.registerTower(weatherTower);
        }

        reader.close();

        for (int i = 0; i < simulations; i++) {
            weatherTower.changeWeather();
        }
    }
}
