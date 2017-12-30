package ch.frankel.hesge.algo;

import ch.frankel.hesge.algo.model.Country;
import ch.frankel.hesge.algo.model.Location;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TestM {

    private M m;

    @BeforeTest
    protected void setUp() {
        m = new M();
    }

    @Test
    public void locationShouldImplementHashCode() {
        Location location = new Location(0.0, 0.0, "Lyon", Country.FRANCE);
        Location sameLocation = new Location(0.0, 0.0, "Lyon", Country.FRANCE);
        assertThat(location.hashCode()).isEqualTo(sameLocation.hashCode());
    }

    @Test
    public void locationShouldImplementEquals() {
        Location location = new Location(0.0, 0.0, "Lyon", Country.FRANCE);
        Location sameLocation = new Location(0.0, 0.0, "Lyon", Country.FRANCE);
        assertThat(location).isEqualTo(sameLocation);
    }

    @Test
    public void shouldDeduplicateLocations() {
        Location location = new Location(0.0, 0.0, "Lyon", Country.FRANCE);
        Location sameLocation = new Location(0.0, 0.0, "Lyon", Country.FRANCE);
        Location otherLocation = new Location(1.0, 1.0, "Paris", Country.FRANCE);
        Stream<Location> locations = Stream.of(location, sameLocation, otherLocation);
        Collection<Location> result = m.apply(locations);
        assertThat(result)
                .isNotNull()
                .isNotEmpty()
                .hasSize(2)
                .containsExactlyInAnyOrder(location, otherLocation);
    }
}
