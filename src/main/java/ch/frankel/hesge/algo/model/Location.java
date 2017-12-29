package ch.frankel.hesge.algo.model;

public final class Location {

    private final double latitude;
    private final double longitude;
    private final String city;
    private final Country country;

    public Location(double latitude, double longitude, String city, Country country) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.country = country;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }
}
