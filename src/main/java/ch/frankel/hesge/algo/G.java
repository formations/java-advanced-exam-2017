package ch.frankel.hesge.algo;

import ch.frankel.hesge.algo.model.Restaurant;
import ch.frankel.hesge.algo.model.Star;

import java.util.List;
import java.util.function.BiConsumer;

public class G implements BiConsumer<Restaurant, List<Star>> {

    /**
     * Modifier le type générique de la signature de la méthode Restaurant.add(Collection<Chef>) pour que l'implémentation suivante compile.
     */
    public void accept(Restaurant restaurant, List<Star> stars) {
        restaurant.add(stars); // Décommenter pour vérifier
    }
}
