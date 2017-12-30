package ch.frankel.hesge.algo;

import ch.frankel.hesge.algo.model.Chef;
import ch.frankel.hesge.algo.model.Location;
import ch.frankel.hesge.algo.model.Restaurant;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static ch.frankel.hesge.algo.model.Country.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TestA {

    private A a;

    @BeforeTest
    protected void setUp() {
        a = new A();
    }

    @Test
    public void returnedCollectionShouldNotBeTheSameAsInputCollection() {
        Restaurant restaurant = new Restaurant("Home Sweet Home", new Location(0.00, 0.00, "Bern", SWITZERLAND), Collections.emptyList());
        Collection<Restaurant> restaurants = Collections.singleton(restaurant);
        Collection<Restaurant> result = a.apply(restaurants);
        assertThat(result).isNotSameAs(restaurants);
    }

    @DataProvider
    public Object[][] data() {
        Chef swissChef1 = new Chef("John", "Doe", SWITZERLAND);
        Chef swissChef2 = new Chef("Jane", "Doe", SWITZERLAND);
        Chef frenchChef1 = new Chef("Jean", "Doe", FRANCE);
        Chef frenchChef2 = new Chef("Jeanette", "Doe", FRANCE);
        Chef germanChef = new Chef("Hans", "Schmidt", GERMANY);

        Restaurant twoChefsSwissRestaurant = new Restaurant("Generic Swiss Restaurant",
                new Location(1, 1, "Geneva", SWITZERLAND),
                Arrays.asList(swissChef1, swissChef2));
        Restaurant twoChefsFrenchRestaurant = new Restaurant("Generic French Restaurant",
                new Location(2, 2, "Paris", FRANCE),
                Arrays.asList(frenchChef1, frenchChef2));
        Restaurant mixedChefsFrenchRestaurant = new Restaurant("Mix",
                new Location(3, 3, "Lille", FRANCE),
                Arrays.asList(frenchChef1, frenchChef2, swissChef1, swissChef2, germanChef));
        Restaurant onlyForeignChefsRestaurant = new Restaurant("Only Foreigners",
                new Location(4, 4, "Londres", UK),
                Arrays.asList(frenchChef1, frenchChef2, swissChef1, swissChef2, germanChef));
        Restaurant noChefRestaurant = new Restaurant("No Chef",
                new Location(5, 5, "Birmigham", UK),
                Collections.emptyList());

        Object[][] data = new Object[5][2];
        data[0] = new Object[]{
                Collections.singletonList(twoChefsFrenchRestaurant),
                Collections.singletonList(twoChefsFrenchRestaurant)
        };
        data[1] = new Object[]{
                Collections.singletonList(twoChefsSwissRestaurant),
                Collections.singletonList(twoChefsSwissRestaurant)
        };
        data[2] = new Object[]{
                Arrays.asList(twoChefsFrenchRestaurant, twoChefsSwissRestaurant, mixedChefsFrenchRestaurant, onlyForeignChefsRestaurant),
                Arrays.asList(twoChefsFrenchRestaurant, twoChefsSwissRestaurant, mixedChefsFrenchRestaurant),
        };
        data[3] = new Object[]{Collections.emptyList(), Collections.emptyList()};
        data[4] = new Object[]{Collections.singletonList(noChefRestaurant), Collections.emptyList()};
        return data;
    }

    @Test(dataProvider = "data")
    public void shouldReturnExpectedCollection(Collection<Restaurant> input, Collection<Restaurant> expected) {
        Collection<Restaurant> result = a.apply(input);
        Restaurant[] restaurants = new Restaurant[expected.size()];
        assertThat(result).containsExactlyInAnyOrder(expected.toArray(restaurants));
    }
}