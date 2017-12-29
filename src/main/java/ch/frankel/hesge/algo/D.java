package ch.frankel.hesge.algo;

import ch.frankel.hesge.algo.model.Chef;
import ch.frankel.hesge.algo.model.Restaurant;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class D implements Function<Collection<Restaurant>, Map<Restaurant, Collection<Chef>>> {

    /**
     * Ventiler les Chef par Restaurant, la clé est le Restaurant, la valeur la collection de Chef associés à ce Restaurant.
     */
    @Override
    public Map<Restaurant, Collection<Chef>> apply(Collection<Restaurant> restaurants) {
        Map<Restaurant, Collection<Chef>> chefsByRestaurant = new HashMap<>(); // DO NOT EDIT

        return chefsByRestaurant; // DO NOT EDIT
    }
}
