package ch.frankel.hesge.algo;

import ch.frankel.hesge.algo.model.Chef;
import ch.frankel.hesge.algo.model.Restaurant;
import ch.frankel.hesge.algo.model.Star;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class TestI {

    @Test
    public void checkCompile() {
        I i = new I();
        i.accept(new ArrayList<Chef>());
        i.accept(new LinkedList<Chef>());
        // i.accept(new HashSet<Restaurant>());
        i.accept(new ArrayList<Star>());
    }
}
