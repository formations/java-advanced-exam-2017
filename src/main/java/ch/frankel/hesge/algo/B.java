package ch.frankel.hesge.algo;

import ch.frankel.hesge.algo.model.Chef;
import ch.frankel.hesge.algo.model.Restaurant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class B implements Consumer<List<Chef>> {

    /**
     * En utilisant la classe interne ByStarsComparator, trier les Chef par ordre décroissant de leur stars.
     */
    @Override
    public void accept(List<Chef> chefs) {
        chefs.sort(new ByStarsComparator());
    }

    public static class ByStarsComparator implements Comparator<Chef> {

        @Override
        public int compare(Chef chef1, Chef chef2) {
            return chef2.getStars() - chef1.getStars();
        }
    }
}
