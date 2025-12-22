package ro.academyplus.avaj.tower;

import java.util.ArrayList;
import java.util.List;
import ro.academyplus.avaj.aircraft.Flyable;

public abstract class Tower {
    
    private List<Flyable>   observers;

    protected Tower() {
        observers = new ArrayList<>();
    }

    public void register(Flyable p_flyable) { observers.add(p_flyable); }

    public void unregister(Flyable p_flyable) { observers.remove(p_flyable); }

    protected void conditionChanged() {
        //implement
    }

}