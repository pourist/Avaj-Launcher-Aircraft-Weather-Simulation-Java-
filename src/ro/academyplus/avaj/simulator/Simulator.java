package ro.academyplus.avaj.simulator;

public class Simulator {
	
	public static void main(String[] args) {
		validateArguments(args);
	}

	private static void validateArguments(String[] args) {
		if (args.length != 1) {
			throw new IllegalArgumentException(
				"Usage: java Simulator <scenario_file>"
			);
		}
	}
}
