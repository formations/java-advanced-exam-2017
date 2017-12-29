package ch.frankel.hesge.algo.model;

public class Star extends Chef {

    public Star(String firstName, String lastName, Country citizenship) {
        super(firstName, lastName, citizenship);
    }

    @Override
    public int getStars() {
        return 5;
    }

    @Override
    public void setStars(int stars) {
        // DO NOTHING
    }
}
