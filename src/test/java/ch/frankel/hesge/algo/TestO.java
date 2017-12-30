package ch.frankel.hesge.algo;

import ch.frankel.hesge.algo.model.Chef;
import ch.frankel.hesge.algo.model.Country;
import ch.frankel.hesge.algo.model.Location;
import ch.frankel.hesge.algo.model.Restaurant;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class TestO {

    private O o;

    @BeforeTest
    protected void setUp() {
        o = new O();
    }

    @DataProvider
    public Object[][] data() {

        Chef chef1 = new Chef("Johannes", "Doe", Country.GERMANY);
        chef1.setStars(1);

        Location lyon = new Location(0, 0, "Lyon", Country.FRANCE);
        Restaurant restaurant1 = new Restaurant("One Chef", lyon, Collections.singletonList(chef1));

        Chef chef1Bis = new Chef("Jean", "Doe", Country.FRANCE);
        chef1Bis.setStars(1);

        Restaurant restaurant2 = new Restaurant("Two Chefs", lyon, Arrays.asList(chef1, chef1Bis));

        Chef chef2 = new Chef("Karl", "Doe", Country.GERMANY);
        Chef chef2Bis = new Chef("Kurt", "Doe", Country.GERMANY);
        Chef chef4 = new Chef("Klein", "Doe", Country.GERMANY);
        chef2.setStars(2);
        chef2Bis.setStars(2);
        chef4.setStars(4);

        Restaurant restaurant3 = new Restaurant("Four Chefs", lyon, Arrays.asList(chef1, chef1Bis, chef2, chef2Bis, chef4));

        Object[][] data = new Object[3][2];
        data[0] = new Object[]{restaurant1, 1.0};
        data[1] = new Object[]{restaurant2, 1.0};
        data[2] = new Object[]{restaurant3, 2.0};

        return data;
    }

    @Test(dataProvider = "data")
    public void shouldComputeCorrectAverage(Restaurant input, double expected) {
        double result = o.applyAsDouble(input);
        assertThat(result).isEqualTo(expected);
    }
}
