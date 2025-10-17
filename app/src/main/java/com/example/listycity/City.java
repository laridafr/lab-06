package com.example.listycity;

/**
 * This class represents a City
 */
public class City implements Comparable<City> {
    private String city;
    private String province;

    /**
     * Constructs a new City object.
     *
     * @param city
     *          the city name (e.g., "Edmonton")
     * @param province
     *          the province or state name (e.g., "Alberta")
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Returns city name
     * @return
     *      city name
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns province name
     * @return
     *      province name
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method compares City
     * @param o the object to be compared.
     * @return int
     */

    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCity());
    }
}
