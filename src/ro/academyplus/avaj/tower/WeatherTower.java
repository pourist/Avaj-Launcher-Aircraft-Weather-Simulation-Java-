package ro.academyplus.avaj.tower;

import ro.academyplus.avaj.aircraft.Flyable;


public class WeatherTower extends Tower {

    public WeatherTower() {
        super();
    }

    @Override
    public void register(Flyable p_flyable) {
        super.addObserver(p_flyable);
        //print to file
    }

    @Override
    public void unregister(Flyable p_flyable) {
        super.removeObserver(p_flyable);
        //print to file
    }

    @Override
    protected void conditionChanged() {

    }
}