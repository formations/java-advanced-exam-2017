package ch.frankel.hesge.algo.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Double.compare(location.latitude, latitude) == 0 &&
                Double.compare(location.longitude, longitude) == 0 &&
                Objects.equals(city, location.city) &&
                country == location.country;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude, city, country);
    }
}
