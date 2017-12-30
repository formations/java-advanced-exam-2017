package ch.frankel.hesge.algo;

import ch.frankel.hesge.algo.model.Location;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class M implements Function<Stream<Location>, Collection<Location>> {

    /**
     * Reprendre la question E en utilisant l'API Stream.
     */
    @Override
    public Collection<Location> apply(Stream<Location> locations) {
        return locations.collect(Collectors.toSet());
    }
}
