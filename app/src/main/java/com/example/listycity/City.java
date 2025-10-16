package com.example.listycity;

/**
 * THis class represnts a City
 */
public class City implements Comparable<City> {
    private String city;
    private String province;

    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    public String getCity() {
        return city;
    }

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
