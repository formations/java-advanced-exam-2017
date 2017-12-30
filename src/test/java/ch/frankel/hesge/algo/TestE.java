package ch.frankel.hesge.algo;

import ch.frankel.hesge.algo.model.Country;
import ch.frankel.hesge.algo.model.Location;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class TestE {

    private E e;

    @BeforeTest
    protected void setUp() {
        e = new E();
    }

    @Test
    public void locationShouldImplementHashCode() {
        Location location = new Location(0.0, 0.0, "Lyon", Country.FRANCE);
        Location sameLocation = new Location(0.0, 0.0, "Lyon", Country.FRANCE);
        Assertions.assertThat(location.hashCode()).isEqualTo(sameLocation.hashCode());
    }

    @Test
    public void locationShouldImplementEquals() {
        Location location = new Location(0.0, 0.0, "Lyon", Country.FRANCE);
        Location sameLocation = new Location(0.0, 0.0, "Lyon", Country.FRANCE);
        Assertions.assertThat(location).isEqualTo(sameLocation);
    }

    @Test
    public void shouldDeduplicateLocations() {
        Location location = new Location(0.0, 0.0, "Lyon", Country.FRANCE);
        Location sameLocation = new Location(0.0, 0.0, "Lyon", Country.FRANCE);
        Location otherLocation = new Location(1.0, 1.0, "Paris", Country.FRANCE);
        Collection<Location> locations = Arrays.asList(location, sameLocation, otherLocation);
        Collection<Location> result = e.apply(locations);
        Assertions.assertThat(result)
                .isNotNull()
                .isNotEmpty()
                .hasSize(2)
                .containsExactlyInAnyOrder(location, otherLocation);
    }
}
