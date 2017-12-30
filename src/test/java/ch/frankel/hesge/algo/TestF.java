package ch.frankel.hesge.algo;

import ch.frankel.hesge.algo.model.Chef;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static ch.frankel.hesge.algo.model.Country.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TestF {

    private F f;

    @BeforeTest
    protected void setUp() {
        f = new F();
    }

    @Test
    public void shouldIncrementStars() {
        Chef chef1 = new Chef("John", "Doe", SWITZERLAND);
        Chef chef2 = new Chef("Jane", "Doe", SWITZERLAND);
        Chef chef3 = new Chef("Jean", "Doe", FRANCE);
        Chef chef4 = new Chef("Jeanette", "Doe", FRANCE);
        Chef chef5 = new Chef("Hans", "Schmidt", GERMANY);
        List<Chef> chefs = Arrays.asList(chef1, chef2, chef3, chef4, chef5);
        for (int i = 0; i < chefs.size(); i++) {
            chefs.get(i).setStars(i);
        }
        f.accept(chefs.iterator());
        for (int i = 0; i < chefs.size(); i++) {
            assertThat(chefs.get(i).getStars()).isEqualTo(i + 1);
        }
    }
}
