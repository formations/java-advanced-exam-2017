package ch.frankel.hesge.algo;

import java.util.Collection;

public class I {

    /**
     * Modifier la signature de la méthode suivante pour vérifier que la compilation donne les résultats suivants :
     * <p>
     * - new I().accept(new ArrayList<Chef>()) ==> compile
     * - new I().accept(new LinkedList<Chef>()) ==> compile
     * - new I().accept(new HashSet<Restaurant>()) ==> doesn't compile
     * - new I().accept(new ArrayList<Star>()) ==> compile
     */
    public void accept(Collection objects) {

    }
}
