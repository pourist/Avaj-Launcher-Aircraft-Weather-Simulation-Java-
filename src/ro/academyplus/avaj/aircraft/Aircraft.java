package ro.academyplus.avaj.aircraft;

import ro.academyplus.avaj.weather.Coordinates;
import ro.academyplus.avaj.tower.WeatherTower;


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
	public void	registerTower(final WeatherTower p_tower){
		weatherTower = p_tower;
		weatherTower.register(this);
	}
}
