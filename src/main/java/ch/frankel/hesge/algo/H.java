package ch.frankel.hesge.algo;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;

public class H<T> implements BiFunction<T, T, Iterator<T>> {

    /**
     * Implémenter la méthode IterableArray.iterator().
     * <p>
     * Seule la méthode IterableArray.iterator() doit être modifiée, pas celle-ci.
     */
    public Iterator<T> apply(T t1, T t2) {
        return new IterableArray<>(t1, t2).iterator(); // DO NOT EDIT
    }

    public static class IterableArray<T> implements Iterable<T> {

        private final T t1;
        private final T t2;

        public IterableArray(T t1, T t2) {
            this.t1 = t1;
            this.t2 = t2;
        }

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {

                private int cursor = 0;

                @Override
                public boolean hasNext() {
                    return cursor == 0;
                }

                @Override
                public T next() {
                    switch (cursor) {
                        case 0:
                            cursor++;
                            return t1;
                        case 1:
                            cursor++;
                            return t2;
                        default:
                            throw new NoSuchElementException();
                    }
                }
            };
        }
    }
}
