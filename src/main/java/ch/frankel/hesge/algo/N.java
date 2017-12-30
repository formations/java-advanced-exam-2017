package ch.frankel.hesge.algo;

import ch.frankel.hesge.algo.model.Chef;
import ch.frankel.hesge.algo.model.Restaurant;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

public class N implements Function<Restaurant, Collection<Chef>> {

    /**
     * En utilisant l'API Stream, retourner la collection de tous les cooks de tous les Chef d'un Restaurant.
     */
    @Override
    public Collection<Chef> apply(Restaurant restaurant) {
        return restaurant.getChefs().stream().flatMap(chef -> chef.getCooks().stream()).collect(Collectors.toList());
    }
}
