package ro.academyplus.avaj.aircraft;

import ro.academyplus.avaj.tower.WeatherTower;
import ro.academyplus.avaj.weather.Coordinates;


public abstract class Aircraft implements Flyable {

	protected long	 	id;
	protected String	name;
	protected Coordinates	coordinates;
	protected WeatherTower	weatherTower;

	protected	Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
		id = p_id;
		name = p_name;
		coordinates = p_coordinates;
	}

	@Override
	public void	registerTower(WeatherTower p_tower){
		weatherTower = p_tower;
		weatherTower.registerAircraft(this);
	}
}
