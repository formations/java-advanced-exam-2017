package ch.frankel.hesge.algo;

import ch.frankel.hesge.algo.model.Chef;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class J implements Function<Stream<Chef>, List<Chef>> {

    /**
     * Reprendre la question B en utilisant l'API Stream.
     */
    public List<Chef> apply(Stream<Chef> chefs) {
        return chefs.sorted((chef1, chef2) -> chef2.getStars() - chef1.getStars()).collect(Collectors.toList());
    }
}
