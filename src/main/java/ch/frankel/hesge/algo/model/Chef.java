package ch.frankel.hesge.algo.model;

import java.util.ArrayList;
import java.util.Collection;

public class Chef {

    private final String firstName;
    private final String lastName;
    private final Country citizenship;
    private final Collection<Chef> cooks;
    private int stars;

    public Chef(String firstName, String lastName, Country citizenship) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.citizenship = citizenship;
        this.cooks = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Country getCitizenship() {
        return citizenship;
    }

    public int getStars() {
        return stars;
    }

    public Collection<Chef> getCooks() {
        return cooks;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public boolean add(Chef chef) {
        return cooks.add(chef);
    }

    public boolean remove(Chef chef) {
        return cooks.remove(chef);
    }
}
