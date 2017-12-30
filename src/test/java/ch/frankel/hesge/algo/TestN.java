package ch.frankel.hesge.algo;

import ch.frankel.hesge.algo.model.Chef;
import ch.frankel.hesge.algo.model.Location;
import ch.frankel.hesge.algo.model.Restaurant;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static ch.frankel.hesge.algo.model.Country.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TestN {

    private N n;

    @BeforeTest
    protected void setUp() {
        n = new N();
    }

    @DataProvider
    public Object[][] data() {
        Restaurant noChefRestaurant = new Restaurant("No Chef",
                new Location(1, 1, "Gloucester", UK),
                Collections.emptyList());

        Chef noCooksChef = new Chef("John", "Doe", SWITZERLAND);

        Restaurant restaurant1 = new Restaurant("No cooks",
                new Location(2, 2, "Birmigham", UK),
                Collections.singletonList(noCooksChef));

        Chef cook1 = new Chef("Cook", "1", FRANCE);
        Chef cook2 = new Chef("Cook", "2", FRANCE);
        Chef cook3 = new Chef("Cook", "3", FRANCE);
        Chef cook4 = new Chef("Cook", "4", FRANCE);
        Chef cook5 = new Chef("Cook", "5", FRANCE);

        Chef chef1 = new Chef("Chef", "1", GERMANY);
        chef1.add(cook1);
        chef1.add(cook2);
        chef1.add(cook3);

        Restaurant restaurant2 = new Restaurant("1 Chef, 3 Cooks",
                new Location(3, 3, "London", UK),
                Collections.singletonList(chef1));

        Chef chef2 = new Chef("Chef", "2", GERMANY);
        chef2.add(cook4);
        chef2.add(cook5);

        Restaurant restaurant3 = new Restaurant("2 chefs, 5 Cooks",
                new Location(3, 3, "North Hampton", UK),
                Arrays.asList(chef1, chef2));

        Object[][] data = new Object[4][2];
        data[0] = new Object[]{noChefRestaurant, Collections.emptyList()};
        data[1] = new Object[]{restaurant1, Collections.emptyList()};
        data[2] = new Object[]{restaurant2, Arrays.asList(cook1, cook2, cook3)};
        data[3] = new Object[]{restaurant3, Arrays.asList(cook1, cook2, cook3, cook4, cook5)};
        return data;
    }

    @Test(dataProvider = "data")
    public void shouldReturnExpectedResult(Restaurant input, Collection<Chef> expected) {
        Collection<Chef> result = n.apply(input);
        assertThat(result).isNotNull()
                .hasSameSizeAs(expected)
                .hasSameElementsAs(expected);
    }
}
