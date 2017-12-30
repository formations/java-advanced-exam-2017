package ch.frankel.hesge.algo;

import ch.frankel.hesge.algo.model.Chef;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class C implements Consumer<List<Chef>> {

    /**
     * Trier la liste de Chef par ordre de firstName, puis de lastName décroissant sans utiliser de Comparator ni de Stream.
     */
    @Override
    public void accept(List<Chef> chefs) {
        Collections.sort(chefs);
    }
}
