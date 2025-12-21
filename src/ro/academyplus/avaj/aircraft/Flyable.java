package ro.academyplus.avaj.aircraft;

import	ro.academyplus.avaj.tower.WeatherTower;

public interface Flyable {
	
	void	updateConditions();
	
	void	registerTower(WeatherTower p_tower);
}
