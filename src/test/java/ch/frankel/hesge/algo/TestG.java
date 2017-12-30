package ch.frankel.hesge.algo;

import ch.frankel.hesge.algo.model.Location;
import ch.frankel.hesge.algo.model.Restaurant;
import ch.frankel.hesge.algo.model.Star;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static ch.frankel.hesge.algo.model.Country.SWITZERLAND;
import static org.assertj.core.api.Assertions.assertThat;

public class TestG {

    @Test
    public void checkCompile() {
        Restaurant restaurant = new Restaurant("Generic Swiss Restaurant",
                new Location(1, 1, "Geneva", SWITZERLAND),
                Collections.emptyList());
        Star star1 = new Star("John", "Doe", SWITZERLAND);
        Star star2 = new Star("Jane", "Doe", SWITZERLAND);
        List<Star> stars = Arrays.asList(star1, star2);
        restaurant.add(stars);
        assertThat(restaurant.getChefs()).containsExactlyInAnyOrder(star1, star2);
    }
}
