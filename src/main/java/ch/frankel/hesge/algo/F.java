package ch.frankel.hesge.algo;

import ch.frankel.hesge.algo.model.Chef;

import java.util.Iterator;
import java.util.function.Consumer;

public class F implements Consumer<Iterator<Chef>> {

    /**
     * Pour tous les Chef passés en paramètre, augmenter leur attribut stars de 1.
     */
    @Override
    public void accept(Iterator<Chef> chefs) {
        while (chefs.hasNext()) {
            Chef chef = chefs.next();
            int stars = chef.getStars();
            chef.setStars(stars + 1);
        }
    }
}
