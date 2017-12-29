package ch.frankel.hesge.algo.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Restaurant {

    private final String name;
    private final Location location;
    private final List<Chef> chefs;

    public Restaurant(String name, Location location, Collection<Chef> chefs) {
        this.name = name;
        this.location = location;
        this.chefs = new ArrayList<>();
        add(chefs);
    }

    public Collection<Chef> getChefs() {
        return chefs;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public boolean add(Chef chef) {
        return this.chefs.add(chef);
    }

    public boolean remove(Chef chef) {
        return this.chefs.remove(chef);
    }

    public void add(Collection<Chef> chefs) {
        this.chefs.addAll(chefs);
    }

    public void remove(Collection<Chef> chefs) {
        this.chefs.removeAll(chefs);
    }
}
