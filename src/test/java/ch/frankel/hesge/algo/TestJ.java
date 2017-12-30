package ch.frankel.hesge.algo;

import ch.frankel.hesge.algo.model.Chef;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static ch.frankel.hesge.algo.model.Country.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TestJ {

    private J j;

    @BeforeTest
    protected void setUp() {
        j = new J();
    }

    @DataProvider
    public Object[][] data() {
        Chef star0 = new Chef("John", "Doe", SWITZERLAND);
        Chef star1 = new Chef("Jane", "Doe", SWITZERLAND);
        Chef star2 = new Chef("Jean", "Doe", FRANCE);
        Chef star3 = new Chef("Jeanette", "Doe", FRANCE);
        Chef star4 = new Chef("Hans", "Schmidt", GERMANY);
        List<Chef> chefs = Arrays.asList(star0, star1, star2, star3, star4);
        for (int i = 0; i < chefs.size(); i++) {
            Chef chef = chefs.get(i);
            chef.setStars(i);
        }
        int count = 5;
        Object[][] data = new Object[count + 1][0];
        for (int i = 0; i < count; i++) {
            Collections.shuffle(chefs);
            data[i] = new Object[]{
                    Collections.unmodifiableList(chefs),
                    Arrays.asList(star4, star3, star2, star1, star0)
            };
        }
        data[5] = new Object[]{Collections.emptyList(), Collections.emptyList()};
        return data;
    }

    @Test(dataProvider = "data")
    public void shouldTransformCollection(List<Chef> input, List<Chef> expected) {
        List<Chef> result = j.apply(input.stream());
        Chef[] chefs = new Chef[expected.size()];
        assertThat(result).containsExactly(expected.toArray(chefs));
    }
}
