package ro.academyplus.avaj.tower;

import java.util.ArrayList;
import java.util.List;
import ro.academyplus.avaj.aircraft.Flyable;

public abstract class Tower {
    
    private List<Flyable>   observers;

    protected Tower() {
        observers = new ArrayList<>();
    }

    public abstract void register(Flyable p_flyable);

    public abstract  void unregister(Flyable p_flyable);

    protected abstract void conditionChanged();

    protected void addObserver(Flyable f) { observers.add(f); }
    protected void removeObserver(Flyable f) { observers.remove(f); }
}