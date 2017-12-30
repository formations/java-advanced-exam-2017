package ch.frankel.hesge.algo;

import ch.frankel.hesge.algo.model.Chef;
import ch.frankel.hesge.algo.model.Restaurant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.UnaryOperator;

public class A implements UnaryOperator<Collection<Restaurant>> {

    /**
     * Retourner la collection des Restaurant qui ont des Chef dont l'attribut citizenship est le même que la location du Restaurant.
     */
    public Collection<Restaurant> apply(Collection<Restaurant> restaurants) {
        Collection<Restaurant> restaurantsWhichHaveLocalChefs = new ArrayList<>(); // DO NOT EDIT
        for (Restaurant restaurant: restaurants) {
            for (Chef chef : restaurant.getChefs()) {
                if (chef.getCitizenship() == restaurant.getLocation().getCountry()) {
                    restaurantsWhichHaveLocalChefs.add(restaurant);
                    break;
                }
            }
        }
        return restaurantsWhichHaveLocalChefs; // DO NOT EDIT
    }
}
