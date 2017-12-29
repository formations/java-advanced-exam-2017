package ch.frankel.hesge.algo;

import ch.frankel.hesge.algo.model.Chef;

import java.util.List;
import java.util.function.Consumer;

public class C implements Consumer<List<Chef>> {

    /**
     * Sans utiliser de Comparator ni de Stream, trier la liste de Chef par ordre de firstName, puis de lastName décroissant.
     */
    @Override
    public void accept(List<Chef> chefs) {

    }
}
