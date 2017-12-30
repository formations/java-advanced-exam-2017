package ch.frankel.hesge.algo;

import ch.frankel.hesge.algo.model.Chef;
import ch.frankel.hesge.algo.model.Location;
import ch.frankel.hesge.algo.model.Restaurant;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Stream;

import static ch.frankel.hesge.algo.model.Country.*;
import static ch.frankel.hesge.algo.model.Country.UK;
import static org.assertj.core.api.Assertions.assertThat;

public class TestL {

    private L l;

    @BeforeTest
    protected void setUp() {
        l = new L();
    }

    @DataProvider
    public Object[][] data() {
        Chef swissChef1 = new Chef("John", "Doe", SWITZERLAND);
        Chef swissChef2 = new Chef("Jane", "Doe", SWITZERLAND);
        Chef frenchChef1 = new Chef("Jean", "Doe", FRANCE);
        Chef frenchChef2 = new Chef("Jeanette", "Doe", FRANCE);
        Chef germanChef = new Chef("Hans", "Schmidt", GERMANY);

        Restaurant restaurant1 = new Restaurant("Restaurant 1",
                new Location(1, 1, "Geneva", SWITZERLAND),
                Arrays.asList(swissChef1, swissChef2));
        Restaurant restaurant2 = new Restaurant("Restaurant 2",
                new Location(2, 2, "Paris", FRANCE),
                Arrays.asList(frenchChef1, frenchChef2));
        Restaurant restaurant3 = new Restaurant("Restaurant 3",
                new Location(3, 3, "Lille", FRANCE),
                Arrays.asList(frenchChef1, frenchChef2, swissChef1, swissChef2, germanChef));
        Restaurant restaurant4 = new Restaurant("Restaurant 4",
                new Location(4, 4, "Londres", UK),
                Arrays.asList(frenchChef1, frenchChef2, swissChef1, swissChef2, germanChef));
        Restaurant noChefRestaurant = new Restaurant("No Chef",
                new Location(5, 5, "Birmigham", UK),
                Collections.emptyList());
        Object[][] data = new Object[4][2];
        Map<Restaurant, Collection<Chef>> mappings1 = new HashMap<>();
        mappings1.put(restaurant1, restaurant1.getChefs());
        data[0] = new Object[]{
                Stream.of(restaurant1),
                mappings1
        };
        Map<Restaurant, Collection<Chef>> mappings2 = new HashMap<>();
        mappings2.put(restaurant2, restaurant2.getChefs());
        mappings2.put(restaurant3, restaurant3.getChefs());
        data[1] = new Object[]{
                Stream.of(restaurant2, restaurant3),
                mappings2
        };
        Map<Restaurant, Collection<Chef>> mappings3 = new HashMap<>();
        mappings3.put(restaurant2, restaurant2.getChefs());
        mappings3.put(restaurant3, restaurant3.getChefs());
        mappings3.put(restaurant4, restaurant4.getChefs());
        data[2] = new Object[]{
                Stream.of(restaurant2, restaurant3, restaurant4),
                mappings3
        };
        Map<Restaurant, Collection<Chef>> mappings4 = new HashMap<>();
        mappings4.put(noChefRestaurant, Collections.emptyList());
        data[3] = new Object[]{
                Stream.of(noChefRestaurant),
                mappings4
        };

        return data;
    }

    @Test(dataProvider = "data")
    public void shouldReturnExpectedMap(Stream<Restaurant> input, Map<Restaurant, Collection<Chef>> expected) {
        Map<Restaurant, Collection<Chef>> result = l.apply(input);
        Map.Entry<Restaurant, Collection<Chef>>[] array = new Map.Entry[expected.size()];
        assertThat(result)
                .isNotNull()
                .containsExactly(expected.entrySet().toArray(array));
    }
}
