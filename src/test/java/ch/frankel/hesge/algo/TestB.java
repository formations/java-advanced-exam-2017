package ch.frankel.hesge.algo;

import ch.frankel.hesge.algo.model.Chef;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static ch.frankel.hesge.algo.model.Country.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TestB {

    private B b;

    @BeforeTest
    protected void setUp() {
        b = new B();
    }

    @DataProvider
    public Object[][] data() {
        Chef star0 = new Chef("Star", "0", SWITZERLAND);
        Chef star1 = new Chef("Star", "1", SWITZERLAND);
        Chef star2 = new Chef("Star", "2", FRANCE);
        Chef star3 = new Chef("Star", "3", FRANCE);
        Chef star4 = new Chef("Star", "4", GERMANY);
        List<Chef> chefs = Arrays.asList(star0, star1, star2, star3, star4);
        for (int i = 0; i < chefs.size(); i++) {
            Chef chef = chefs.get(i);
            chef.setStars(i);
        }
        int count = 5;
        Object[][] data = new Object[count + 1][0];
        for (int i = 0; i < count; i++) {
            List<Chef> copy = new ArrayList<>(chefs);
            Collections.shuffle(copy);
            data[i] = new Object[]{
                    copy,
                    Arrays.asList(star4, star3, star2, star1, star0)
            };
        }
        data[5] = new Object[] {Collections.emptyList(), Collections.emptyList()};
        return data;
    }

    @Test(dataProvider = "data")
    public void shouldTransformCollection(List<Chef> input, List<Chef> expected) {
        b.accept(input);
        Chef[] chefs = new Chef[expected.size()];
        assertThat(input).containsExactly(expected.toArray(chefs));
    }
}
