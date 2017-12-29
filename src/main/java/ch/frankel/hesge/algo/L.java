package ch.frankel.hesge.algo;

import ch.frankel.hesge.algo.model.Chef;
import ch.frankel.hesge.algo.model.Restaurant;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public class L implements Function<Stream<Restaurant>, Map<Restaurant, Collection<Chef>>> {

    /**
     * Reprendre la question D en utilisant l'API Stream.
     */
    @Override
    public Map<Restaurant, Collection<Chef>> apply(Stream<Restaurant> restaurants) {
        return null;
    }
}
