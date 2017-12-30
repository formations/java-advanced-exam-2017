package ch.frankel.hesge.algo;

import ch.frankel.hesge.algo.model.Chef;
import ch.frankel.hesge.algo.model.Restaurant;

import java.util.function.ToDoubleFunction;

public class O implements ToDoubleFunction<Restaurant> {

    /**
     * Retourner la moyenne des stars des Chef d'un Restaurant (sans prendre en compte les cooks d'un Chef).
     */
    @Override
    public double applyAsDouble(Restaurant restaurant) {
        return restaurant.getChefs().stream().mapToDouble(Chef::getStars).average().getAsDouble();
    }
}
