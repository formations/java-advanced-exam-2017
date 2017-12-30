package ch.frankel.hesge.algo;

import ch.frankel.hesge.algo.model.Location;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.UnaryOperator;

public class E implements UnaryOperator<Collection<Location>> {

    /**
     * 1. A partir d'une collection de Location, retourner une collection de Location sans doublons.
     * 2. Modifier la classe Location pour que 2 Locations soient considérées comme des doublons si les attributs latitude, longitude, city et country sont égaux.
     */
    @Override
    public Collection<Location> apply(Collection<Location> locations) {
        return new HashSet<>(locations);
    }
}
