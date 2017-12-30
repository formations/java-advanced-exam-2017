package ch.frankel.hesge.algo;

import ch.frankel.hesge.algo.model.Chef;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static ch.frankel.hesge.algo.model.Country.*;

public class TestC {

    private C c;

    @BeforeTest
    protected void setUp() {
        c = new C();
    }

    @DataProvider
    public Object[][] data() {
        Chef chef0 = new Chef("A", "Doe", SWITZERLAND);
        Chef chef1 = new Chef("B", "A", SWITZERLAND);
        Chef chef2 = new Chef("B", "B", FRANCE);
        Chef chef3 = new Chef("C", "Doe", FRANCE);
        Chef chef4 = new Chef("D", "Schmidt", GERMANY);
        List<Chef> chefs = Arrays.asList(chef0, chef1, chef2, chef3, chef4);
        int count = 5;
        Object[][] data = new Object[count + 1][0];
        for (int i = 0; i < count; i++) {
            List<Chef> copy = new ArrayList<>(chefs);
            Collections.shuffle(copy);
            data[i] = new Object[]{
                    copy,
                    Arrays.asList(chef4, chef3, chef2, chef1, chef0)
            };
        }
        data[5] = new Object[] {Collections.emptyList(), Collections.emptyList()};
        return data;
    }

    @Test(dataProvider = "data")
    public void shouldTransformCollection(List<Chef> input, List<Chef> expected) {
        c.accept(input);
        Chef[] chefs = new Chef[expected.size()];
        Assertions.assertThat(input).containsExactly(expected.toArray(chefs));
    }
}
